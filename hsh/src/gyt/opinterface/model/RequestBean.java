package gyt.opinterface.model;

/**
 * app接口请求bean
 * @author yangyuanjiang
 * @version 2014-08-05
 *
 */
public class RequestBean {
	
	/**
	 * 请求代码
	 */
	private String code;
	/**
	 * 密匙KEY
	 */
	private String key;
	/**
	 * JSON数据
	 */
	private String data;
	
	public RequestBean(){}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
