package gyt.system.model;

import java.util.Date;

/**
 * 公告
 * @author maqinshu
 *
 */
public class NoticeInfo {
	private int notice_id;
	/**  标题 */
	private String title;
	/** 内容 */
	private String context;
	/**创建时间 */
	private Date add_time;
	/** 发布时间 */
	private Date rel_time;
	/** 用于接收页面上的时间*/
	private String time;
	/** 发布人员 */
	private int rel_user_id;
	/** 可读人员 */
	private String limit_user;
	/** 已读人员 */
	private String read_user;
	/** 上传文件 */
	private String file;
	/** 发布人*/
	private String user_name;
	/**  文件数量*/
	private int filenume;
	/**  文件名用于页面显示*/
	private String[] filename;
	/**  公告的序号*/
	private int rownum;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String[] getFilename() {
		return filename;
	}
	public void setFilename(String[] filename) {
		this.filename = filename;
	}
	public int getFilenume() {
		return filenume;
	}
	public void setFilenume(int filenume) {
		this.filenume = filenume;
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Date getRel_time() {
		return rel_time;
	}
	public void setRel_time(Date rel_time) {
		this.rel_time = rel_time;
	}
	public int getRel_user_id() {
		return rel_user_id;
	}
	public void setRel_user_id(int rel_user_id) {
		this.rel_user_id = rel_user_id;
	}
	public String getLimit_user() {
		return limit_user;
	}
	public void setLimit_user(String limit_user) {
		this.limit_user = limit_user;
	}
	public String getRead_user() {
		return read_user;
	}
	public void setRead_user(String read_user) {
		this.read_user = read_user;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
