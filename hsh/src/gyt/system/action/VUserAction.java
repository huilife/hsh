package gyt.system.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import gyt.core.util.MD5;
import gyt.core.util.SysControl;
import gyt.system.model.MenuInfo;
import gyt.system.model.UserInfo;
import gyt.system.service.VUserServiceInterface;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuser")
public class VUserAction {
	
	private static final Logger logger = Logger.getLogger(VUserAction.class);
	
	@Autowired
	private VUserServiceInterface vuserService;
	
	@RequestMapping("/userList")
	public String userList(Model model,HttpSession session){
		logger.info(" UserAction execute !!!");
		return SysControl.PAGE_PATH+"system/vuser/user";
	}

}
