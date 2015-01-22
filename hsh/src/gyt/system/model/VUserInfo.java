package gyt.system.model;

import java.util.Date;
/**
 * 用户表
 * @author maqinshu
 *
 */
public class VUserInfo {
	/** 用户ID **/
	private int ID;
	/** 头像 **/
	private int head_photo;
	/** 登录用户名 **/
	private String username;
	/** 登录密码 **/
	private String password;
	/** 当前状态(1启用，0未启用) **/
	private int status;
	/** 注册时间 **/
	private Date rg_time;
	/** 手机号码 **/
	private String phone;
	/** 电子邮箱 **/
	private String email;
	/** 性别(1男，2女) **/
	private int sex;
	/** 出生年月(生日) **/
	private Date birthday;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getHead_photo() {
		return head_photo;
	}
	public void setHead_photo(int head_photo) {
		this.head_photo = head_photo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRg_time() {
		return rg_time;
	}
	public void setRg_time(Date rg_time) {
		this.rg_time = rg_time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
