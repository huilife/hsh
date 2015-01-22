package gyt.system.model;

import java.util.List;

/**
 * 部门
 * @author yangyuanjiang
 *
 */
public class DepartmentInfo {

	/** 部门ID */
	private int depId;
	/** 上级部门ID */
	private int parentDepId;
	/** 部门名称  */
	private String depName;
	/** 部门描述  */
	private String depDec;
	/** 部门状态  */
	private String status;
	/** 子部门 */
	private List<DepartmentInfo> depList;
	
	
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public int getParentDepId() {
		return parentDepId;
	}
	public void setParentDepId(int parentDepId) {
		this.parentDepId = parentDepId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepDec() {
		return depDec;
	}
	public void setDepDec(String depDec) {
		this.depDec = depDec;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<DepartmentInfo> getDepList() {
		return depList;
	}
	public void setDepList(List<DepartmentInfo> depList) {
		this.depList = depList;
	}
	
	
}
