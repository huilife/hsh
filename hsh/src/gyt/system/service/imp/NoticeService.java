package gyt.system.service.imp;

import gyt.core.util.Page;
import gyt.system.mapping.NoticeMapper;
import gyt.system.model.NoticeInfo;
import gyt.system.service.NoticeServiceInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("/NoticeService")
public class NoticeService implements NoticeServiceInterface {
	
	private NoticeMapper noticeMapper;
	
	@Override
	public void addNotice(NoticeInfo notice) {
		if("系统当前时间！".equals(notice.getTime())){
				notice.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		noticeMapper.insert(notice);
	}
	
	@Override
	public void modifyNotice(NoticeInfo notice) {
		noticeMapper.updateNoticeById(notice);
	}
	
	@Override
	public void delete(String ids) {
			String[] id = ids.split(",");
			for (String string : id) {
				noticeMapper.deleteNoticeByIds(string);
			}
	}
	
	@Autowired
	public void setNoticeMapper(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	public void noticeList(Page page) {
		Map parameterMap = new HashMap();
		parameterMap.put("pageStart", (page.getPageNo()-1)*page.getBarNumbers());
		parameterMap.put("barNumbers", page.getBarNumbers());
		page.setPageTotal(noticeMapper.findNoticeTotal());
		page.buildHtml();
		page.setDataList(noticeMapper.findNoticeList(parameterMap));
	}

	@Override
	public void aListNotice(Page page,int[] arrays) {
		// TODO Auto-generated method stub
		NoticeInfo noticeInfo = noticeMapper.findNoticeById(arrays[0]);
		if(noticeInfo.getFile()!=null){
			String[] str = noticeInfo.getFile().split(",");
			noticeInfo.setFilenume(str.length);
			noticeInfo.setFilename(str);
			page.setConditions(noticeInfo);
		}else{
			noticeInfo.setFilenume(0);
			page.setConditions(noticeInfo);
		}
	}

	@Override
	public void noticeList(Page page,int user_id) {
		// TODO Auto-generated method stub
		Map parameterMap = new HashMap();
		parameterMap.put("pageStart", (page.getPageNo()-1)*page.getBarNumbers());
		parameterMap.put("barNumbers", page.getBarNumbers());
		parameterMap.put("user_id", user_id);
		page.setPageTotal(noticeMapper.findNoticeTotal1());
		page.buildHtml();
		page.setDataList(noticeMapper.findNoticeList1(parameterMap));
	}

	@Override
	public void aListNotice(Page page, int id) {
		// TODO Auto-generated method stub
		NoticeInfo noticeInfo = noticeMapper.displayPage(id);
		if(noticeInfo.getFile()!=null){
			String[] str = noticeInfo.getFile().split(",");
			noticeInfo.setFilenume(str.length);
			noticeInfo.setFilename(str);
			page.setConditions(noticeInfo);
		}else{
			noticeInfo.setFilenume(0);
			page.setConditions(noticeInfo);
		}
		if(noticeInfo.getRownum() > 0){
			page.setTheLastObject(noticeMapper.displayPages(noticeInfo.getRownum() - 1));
		}else{
			page.setTheLastObject(noticeMapper.displayPages(noticeInfo.getRownum()));
		}
		if(noticeInfo.getRownum() < noticeMapper.findNoticeTotal1()){
			page.setTheNextObject(noticeMapper.displayPages(noticeInfo.getRownum() + 1));
		}else{
			page.setTheNextObject(noticeMapper.displayPages(noticeInfo.getRownum()));
		}
	}	
}
