package gyt.system.model;

import java.util.List;

/**
 * 系统用户
 * @author yangyuanjiang
 *
 */
public class UserInfo {

	/** 用户ID */
	private int userId;
	/** 用户名称  */
	private String userName;
	/** 用户密码  */
	private String pwd;
	/** 姓名 */
	private String realName;
	/** 性别 */
	private int sex;
	/** 电话 */
	private String phone;
	/** 邮箱 */
	private String email;
	/** 状态 */
	private String status;
	/** 联系地址 */
	private String address;
	/** 部门  */
	private DepartmentInfo depInfo;
	/** 角色 */
	private RoleInfo roleInfo;
	/** 菜单 */
	private List<MenuInfo> memuList;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DepartmentInfo getDepInfo() {
		return depInfo;
	}
	public void setDepInfo(DepartmentInfo depInfo) {
		this.depInfo = depInfo;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	public List<MenuInfo> getMemuList() {
		return memuList;
	}
	public void setMemuList(List<MenuInfo> memuList) {
		this.memuList = memuList;
	}
	
}
