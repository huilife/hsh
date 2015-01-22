package gyt.system.action;

import gyt.core.util.SysControl;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/village")
public class VillageAction {

	private static final Logger logger = Logger.getLogger(VillageAction.class);
	
	@RequestMapping("/vlist")
	public String vlist(Model model,HttpSession session){
		logger.info(" VillageAction execute vlist!!!");
		return SysControl.PAGE_PATH+"system/village/vlist";
	}

}
