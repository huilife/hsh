package gyt.system.action;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import gyt.core.util.FileUtil;
import gyt.core.util.Page;
import gyt.core.util.SysControl;
import gyt.system.model.NoticeInfo;
import gyt.system.model.UserInfo;
import gyt.system.service.NoticeServiceInterface;
import gyt.system.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeAction {
	@Autowired
	private NoticeServiceInterface noticeService;
	@Autowired
	private UserServiceInterface userService;
	
	/**
	 * 控制页面记录的显示
	 * @return 跳转的页面
	 */
	@RequestMapping("/noticeList")
	public String listNoticeInfo(int pageNo,Model model){
		Page page = new Page(pageNo,20);
		noticeService.noticeList(page);
		model.addAttribute("page",page);
		return SysControl.PAGE_PATH+"system/notice/index-notice";
	}
	/**
	 * 中转到编辑公告主页
	 * @param pageNo
	 * @param model
	 * @param request
	 * @return	String
	 */
	@RequestMapping("/noticeManageList")
	public String listNoticeInfo(int pageNo,Model model,HttpServletRequest request){
		Page page = new Page(pageNo,20);
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute(SysControl.USER_SESSION);
		int user_id = userInfo.getUserId();
		noticeService.noticeList(page,user_id);
		model.addAttribute("page",page);
		return SysControl.PAGE_PATH+"system/notice/index-notice-manage";
	}
	/**
	 * 跳转到添加页面去
	 * @return String
	 */
	@RequestMapping("/toAddNotice")
	public String toAddNotice(){
		
		return SysControl.PAGE_PATH+"system/notice/add-form";
	}
	/**
	 * 插入一条新公告
	 * @param notice
	 * @param request
	 * @return String
	 * @throws IOException
	 */
	@RequestMapping("/addNotice")
	public String addNotice(NoticeInfo notice,HttpServletRequest request) throws IOException{
		UserInfo userinfo = (UserInfo) request.getSession().getAttribute(SysControl.USER_SESSION);
		notice.setRel_user_id(userinfo.getUserId());
		//控制临时文件
		notice.setFile((String) request.getSession().getAttribute("filestring"));
		request.getSession().setAttribute("filestring", null);
		noticeService.addNotice(notice);
		String userName = userinfo.getRealName();
		//临时文件路径
		String  objectFilePath = SysControl.filePath+"scratchfile/"+userName;
		//上传文件路径
		String filePath1 = SysControl.filePath+"upload/"+SysControl.dateFilePath+"/"+userName;
		FileUtil.copyDel(objectFilePath, filePath1);
		return "redirect:/notice/noticeList.do?pageNo=1";
	}
	/**
	 * 查询到数跳转到修改页面
	 * @param arrays
	 * @param model
	 * @return	String
	 */
	@RequestMapping("/toModifyNotice")
	public String toModifyNotice(int[] arrays,Model model){
		Page page = new Page();
		noticeService.aListNotice(page, arrays);
		model.addAttribute("page", page);
		return SysControl.PAGE_PATH+"system/notice/modify-form";
	}
	/**
	 * 公告修改
	 * @param notice
	 * @param request
	 * @return String
	 */
	@RequestMapping("/modifyNotice")
	public String modifyNotice(NoticeInfo notice,HttpServletRequest request){
		UserInfo userinfo = (UserInfo) request.getSession().getAttribute(SysControl.USER_SESSION);
		notice.setRel_user_id(userinfo.getUserId());
		noticeService.modifyNotice(notice);
		return "redirect:/notice/noticeList.do?pageNo=1";
	}
	/**
	 * 删除公告，上传文件没有实现删除
	 * @param delIds
	 * @return String
	 */
	@RequestMapping("/deleteNotice")
	public String deleteNotices(String delIds){
		noticeService.delete(delIds.substring(0, delIds.length()-1));
		return "redirect:/notice/noticeList.do?pageNo=1";
	}
	/**
	 * 我的公告
	 * @param arrays
	 * @param model
	 * @return check-notice
	 */
	@RequestMapping("/checkNotice")
	public String checkNotice(int[] arrays,Model model){
		Page page = new Page();
		noticeService.aListNotice(page, arrays);
		model.addAttribute("page", page);
		return SysControl.PAGE_PATH+"system/notice/check-notice";
	}
	/**
	 * 公告编辑
	 * @param id
	 * @param model
	 * @return check-notice
	 */
	@RequestMapping("/checkNotice1")
	public String checkNotice1(int id,Model model){
		Page page = new Page();
		noticeService.aListNotice(page, id);
		model.addAttribute("page", page);
		return SysControl.PAGE_PATH+"system/notice/check-notice";
	}
}
