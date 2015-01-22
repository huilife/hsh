package gyt.system.model;
/**
 * 小区房产绑定表
 * @author maqinshu
 *
 */
public class UserHouseInfo {
	/** ID */
	private int ID;
	/** 用户ID */
	private int userID;
	/** 小区ID */
	private int vID;
	/** 楼栋房号 */
	private String houseNO;
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
	public int getvID() {
		return vID;
	}
	public void setvID(int vID) {
		this.vID = vID;
	}
	public String getHouseNO() {
		return houseNO;
	}
	public void setHouseNO(String houseNO) {
		this.houseNO = houseNO;
	}
}
