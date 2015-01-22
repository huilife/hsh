package gyt.system.model;
/**
 * 实时车位表
 * @author maqinshu
 *
 */
public class VParkingInfo {
	/** ID */
	private int ID;
	/** 小区ID */
	private int vID;
	/** 总车位 */
	private int total;
	/** 地下车位数 */
	private int u_total;
	/** 地面车位数 */
	private int g_total;
	/** 收费标准 */
	private String charging_standard;
	/** 地下剩余车位数 */
	private int u_be_number;
	/** 地面剩余车位数 */
	private int g_be_number;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getvID() {
		return vID;
	}
	public void setvID(int vID) {
		this.vID = vID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getU_total() {
		return u_total;
	}
	public void setU_total(int u_total) {
		this.u_total = u_total;
	}
	public int getG_total() {
		return g_total;
	}
	public void setG_total(int g_total) {
		this.g_total = g_total;
	}
	public String getCharging_standard() {
		return charging_standard;
	}
	public void setCharging_standard(String charging_standard) {
		this.charging_standard = charging_standard;
	}
	public int getU_be_number() {
		return u_be_number;
	}
	public void setU_be_number(int u_be_number) {
		this.u_be_number = u_be_number;
	}
	public int getG_be_number() {
		return g_be_number;
	}
	public void setG_be_number(int g_be_number) {
		this.g_be_number = g_be_number;
	}
	
}
