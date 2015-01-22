package gyt.system.service;


import gyt.core.util.Page;
import gyt.system.model.NoticeInfo;

public interface NoticeServiceInterface {
	public void noticeList(Page page);
	/**
	 * 新增一条新的公告
	 * @param notice
	 * @return	String
	 */
	public void addNotice(NoticeInfo notice);
	/**
	 * 更新一条公告
	 * @param notice
	 * @return String
	 */
	public void modifyNotice(NoticeInfo notice);
	/**
	 * 删除一条或多条公告
	 * @param id
	 * @return String
	 */
	public void delete(String id);
	
	public void aListNotice(Page page,int[] arrays);
	public void noticeList(Page page,int user_id);
	public void aListNotice(Page page,int id);
	
}
