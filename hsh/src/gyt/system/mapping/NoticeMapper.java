package gyt.system.mapping;

import gyt.system.model.NoticeInfo;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
	/**
	 * 新增
	 * @param noticeInfo
	 */
	public void insert(NoticeInfo noticeInfo);
	/**
	 * 根据id删除公告记录
	 * @param id
	 */
	public void deleteNoticeByIds(String id);
	/**
	 * 更新记录
	 * @param id
	 */
	public void updateNoticeById(NoticeInfo notice);
	/**
	 * 
	 * @return 记录条数
	 */
	public int findNoticeTotal();
	public int findNoticeTotal1();
	/**
	 * 
	 * @return 返回分页查询的记录
	 */
	public List<NoticeInfo> findNoticeList(Map<String,String> parameterMap);
	public NoticeInfo findNoticeById(Integer id);
	
	public List<NoticeInfo> findNoticeList1(Map<String,String> parameterMap);
	public NoticeInfo displayPage(int id);
	public NoticeInfo displayPages(int rownum);
}

