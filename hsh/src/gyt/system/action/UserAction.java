package gyt.system.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import gyt.opinterface.action.MainAction;
import gyt.system.model.DepartmentInfo;
import gyt.system.model.MenuInfo;
import gyt.system.model.UserInfo;
import gyt.system.service.UserServiceInterface;
import gyt.core.util.MD5;
import gyt.core.util.Page;
import gyt.core.util.SysControl;
import gyt.core.util.TreeUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {

	private static final Logger logger = Logger.getLogger(MainAction.class);
	
	@Autowired
	private UserServiceInterface userService;
	
	@RequestMapping("/login")
	public String login(String username,String password,Model model,HttpSession session){
		logger.info(" UserAction execute !!!");
		if(username==null&&password==null){
			return SysControl.PAGE_PATH+"login";
		}
		//获取用户
		UserInfo userinfo = userService.findUser(username,MD5.GetMD5Code(password));
		//用户验证
		if(userinfo==null){
			model.addAttribute("msg", "用户名或密码错误!");
			return SysControl.PAGE_PATH+"login";
		}
		//其他验证
		if(userinfo.getMemuList().size()==0){
			model.addAttribute("msg", "用户登陆超时或没有权限!");
			return SysControl.PAGE_PATH+"login";
		}
		session.setAttribute(SysControl.USER_SESSION, userinfo);
		//跳转到主界面
		return SysControl.PAGE_PATH+"main";
	}
	
	@RequestMapping("/logout")
	public String login(Model model,HttpSession session){
		logger.info(" UserAction execute !!!");
		session.removeAttribute(SysControl.USER_SESSION);
		//跳转到主界面
		return SysControl.PAGE_PATH+"login";
	}
	
	@RequestMapping("/default")
	public String desk(Model model,HttpSession session){
		logger.info(" UserAction execute desk !!!");
		
		//加载工作台数据
		
		//跳转到工作台
		return SysControl.PAGE_PATH+"default";
	}
	
	
	@RequestMapping("/fmenu")
	public String getMenu(String type,String menuId,Model model,HttpSession session){
		model.addAttribute("menuId", menuId);
		if("top".equalsIgnoreCase(type)){
			return SysControl.PAGE_PATH+"top";
		}else if("left".equalsIgnoreCase(type)){
			return SysControl.PAGE_PATH+"left";
		}else{
			List<MenuInfo> menulist = ((UserInfo)session.getAttribute("userinfo")).getMemuList(); 
			String url = menulist.get(0).getItemMenuList().get(0).getItemMenuList().get(0).getUrl();
			return "redirect:/"+url; 
		}
	}
	
	@RequestMapping("/userList")
	public String userList(String username,int pageNo,Model model,HttpSession session){
		Page page = new Page(pageNo, 10);
		userService.userList(page);
		model.addAttribute("page", page);
		return SysControl.PAGE_PATH+"system/user/user";
	}
	
	@RequestMapping("/roleList")
	public String roleList(Model model,HttpSession session){
		model.addAttribute("roleList", userService.roleList());
		return SysControl.PAGE_PATH+"system/user/role";
	}
	
	@RequestMapping("/depList")
	public String depList(Model model,HttpSession session){
		model.addAttribute("depHtml", TreeUtil.bulidDepHtml(userService.findDepByParentId(0)));
		return SysControl.PAGE_PATH+"system/user/dep";
	}
	
	@RequestMapping("/subDepList")
	public @ResponseBody List<DepartmentInfo> subDepList(String depId,Model model,HttpSession session){
		return userService.findSubDepByParentId(Integer.parseInt(depId));
	}
	
	@RequestMapping("/editUser")
	public String editUser(@ModelAttribute UserInfo user,Model model){
		
		return null;
	}
	
	
	public String roleAssignment(UserInfo user,String roles){
		
		return null;
	}
	
}
