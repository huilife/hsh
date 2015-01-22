package gyt.system.model;
/**
 * 照片表
 * @author maqinshu
 *
 */
public class VPhotoInfo {
	/** 照片ID */
	private int ID;
	/** 照片地址 */
	private String path;
	/** 其他描述 */
	private String other;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
}
