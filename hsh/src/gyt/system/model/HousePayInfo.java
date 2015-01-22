package gyt.system.model;

import java.util.Date;

/**
 * 缴费表
 * @author maqinshu
 *
 */
public class HousePayInfo {
	/** ID */
	private int ID;
	/** 房产ID */
	private int houseID;
	/** 费用类型 */
	private int pay_type;
	/** 楼栋房号 */
	private String houseNO;
	/** 描述 */
	private String des;
	/** 金额 */
	private double amount;
	/** 费用开始日期 */
	private Date pay_date_start;
	/** 费用结算日期 */
	private Date pay_date_end;
	/** 状态(1已经缴费，2未缴费) */
	private int status;
	/** 费用生成日期 */
	private Date add_time;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getHouseID() {
		return houseID;
	}
	public void setHouseID(int houseID) {
		this.houseID = houseID;
	}
	public int getPay_type() {
		return pay_type;
	}
	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}
	public String getHouseNO() {
		return houseNO;
	}
	public void setHouseNO(String houseNO) {
		this.houseNO = houseNO;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPay_date_start() {
		return pay_date_start;
	}
	public void setPay_date_start(Date pay_date_start) {
		this.pay_date_start = pay_date_start;
	}
	public Date getPay_date_end() {
		return pay_date_end;
	}
	public void setPay_date_end(Date pay_date_end) {
		this.pay_date_end = pay_date_end;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
}
