package gyt.system.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gyt.core.util.Page;
import gyt.system.mapping.UserMapper;
import gyt.system.model.DepartmentInfo;
import gyt.system.model.MenuInfo;
import gyt.system.model.RoleInfo;
import gyt.system.model.UserInfo;
import gyt.system.service.UserServiceInterface;

@Service("UserService")
public class UserService implements UserServiceInterface{
	
	private UserMapper userMapper;
	
	@Override
	public UserInfo addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUser(String userName,String pwd) {
		// TODO Auto-generated method stub
		Map<String, String> parameterMap = new HashMap();
		parameterMap.put("userName", userName);
		parameterMap.put("pwd", pwd);
		UserInfo userinfo = userMapper.findUserByName(parameterMap);
		if(userinfo != null){
			userinfo.setRoleInfo(userMapper.findRoleByUserId(userinfo.getUserId()));
			List<MenuInfo> menuListAll = userMapper.findMenuListByRoleId(userinfo.getRoleInfo().getRoleId());
			List<MenuInfo> menuList = orderMenuList(menuListAll);
			userinfo.setMemuList(menuList);
		}
		return userinfo;
	}
	
	/**
	 * 重新对菜单进行排序，
	 * @param menuListAll
	 * @return
	 */
	public List<MenuInfo> orderMenuList(List<MenuInfo> menuListAll){
		if(menuListAll == null || menuListAll.size()==0){
			return menuListAll;
		}
		List<MenuInfo> menuList1 = new ArrayList<MenuInfo>();
		//一级菜单
		for(MenuInfo menu1 : menuListAll){
			if(menu1.getParentMenuId() == 0){
				List<MenuInfo> menuList2 = new ArrayList<MenuInfo>();
				//二级菜单
				for(MenuInfo menu2 : menuListAll){
					if(menu2.getParentMenuId() == menu1.getMenuId()){
						List<MenuInfo> menuList3 = new ArrayList<MenuInfo>();
						//三级菜单
						for(MenuInfo menu3 : menuListAll){
							if(menu3.getParentMenuId() == menu2.getMenuId()){
								menuList3.add(menu3);
							}
						}
						menu2.setItemMenuList(menuList3);
						menuList2.add(menu2);
					}
				}
				menu1.setItemMenuList(menuList2);
				menuList1.add(menu1);
			}
		}
		return menuList1;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void userList(Page page) {
		/** 封装参数 */
		Map parameterMap = new HashMap();
		parameterMap.put("pageStart", (page.getPageNo()-1)*page.getBarNumbers());
		parameterMap.put("barNumbers", page.getBarNumbers());
		page.setPageTotal(userMapper.findUserTotal(parameterMap));
		page.buildHtml();
		page.setDataList(userMapper.findUserList(parameterMap));
		
	}

	@Override
	public List<RoleInfo> roleList() {
		/** 封装参数 */
		Map parameterMap = new HashMap();
		/** 查询  */
		return userMapper.findRoleList(parameterMap);
	}

	@Override
	public List<DepartmentInfo> findDepByParentId(int depId) {
		//组织架构最多只能前嵌套4层
		List<DepartmentInfo> depList = userMapper.findDepByParentId(depId);
		if(depList != null && depList.size() > 0){
			for(DepartmentInfo depInfo : depList){
				depInfo.setDepList(findDepByParentId(depInfo.getDepId()));
			}
		}
		return depList;
	}

	@Override
	public List<DepartmentInfo> findSubDepByParentId(int depId) {
		// TODO Auto-generated method stub
		return userMapper.findDepByParentId(depId);
	}
	
}
