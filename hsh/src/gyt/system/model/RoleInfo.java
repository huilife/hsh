package gyt.system.model;

/**
 * 角色
 * @author yangyuanjiang
 *
 */
public class RoleInfo {
	/** 角色ID */
	private int roleId;
	/** 角色名称 */
	private String roleName;
	/** 角色描述 */
	private String roleDec;
	/** 角色状态 */
	private int status;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDec() {
		return roleDec;
	}

	public void setRoleDec(String roleDec) {
		this.roleDec = roleDec;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
