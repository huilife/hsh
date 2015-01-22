package gyt.system.model;

import java.util.Date;

/**
 * 投诉建议表
 * @author maqinshu
 *
 */
public class UserSugInfo {
	/** ID */
	private int ID;
	/** 用户ID */
	private int userID;
	/** 类型(1投诉，2建议) */
	private int sug_type;
	/** 内容 */
	private String content;
	/** 处理回复 */
	private String handle_des;
	/** 处理状态(1等待，2已处理) */
	private String handle_status;
	/** 照片(多张以逗号隔开) */
	private String photos;
	/** 是否匿名(1匿名，2实名) */
	private int is_anonymou;
	/** 创建日期 */
	private Date add_time;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getSug_type() {
		return sug_type;
	}
	public void setSug_type(int sug_type) {
		this.sug_type = sug_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHandle_des() {
		return handle_des;
	}
	public void setHandle_des(String handle_des) {
		this.handle_des = handle_des;
	}
	public String getHandle_status() {
		return handle_status;
	}
	public void setHandle_status(String handle_status) {
		this.handle_status = handle_status;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public int getIs_anonymou() {
		return is_anonymou;
	}
	public void setIs_anonymou(int is_anonymou) {
		this.is_anonymou = is_anonymou;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
}
