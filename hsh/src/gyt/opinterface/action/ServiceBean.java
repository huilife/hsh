package gyt.opinterface.action;

/**
 * 业务bean
 * @author yangyuanjiang
 * 
 */
public class ServiceBean{
	/** 业务代码 */
	private int code;
	/** 业务名称 */
	private String modelName;
	/** 业务方法 */
	private String modelMethod;
	/** 业务描述 */
	private String modelDes;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelMethod() {
		return modelMethod;
	}
	public void setModelMethod(String modelMethod) {
		this.modelMethod = modelMethod;
	}
	public String getModelDes() {
		return modelDes;
	}
	public void setModelDes(String modelDes) {
		this.modelDes = modelDes;
	}
	
}
