package gyt.system.mapping;

import java.util.List;
import java.util.Map;

import gyt.system.model.DepartmentInfo;
import gyt.system.model.MenuInfo;
import gyt.system.model.RoleInfo;
import gyt.system.model.UserInfo;

public interface UserMapper {

	public UserInfo findUserByName(Map<String,String> parameterMap);
	
	public RoleInfo findRoleByUserId(int userId);
	
	public List<MenuInfo> findMenuListByRoleId(int roleId);
	
	public List<MenuInfo> findMenuListByMenuId(int menuId);
	
	public List<UserInfo> findUserList(Map<String,String> parameterMap);
	
	public int findUserTotal(Map<String,String> parameterMap);
	
	public List<RoleInfo> findRoleList(Map<String,String> parameterMap);
	
	public List<DepartmentInfo> findDepByParentId(int depId);
	
//	public int findUserByNameNotice(String name);
}

