package gyt.opinterface.model;

/**
 * app 接口返回bean
 * @author yangyuanjiang
 * @version 2014-08-05
 *
 */
public class ResponseBean {
	
	/**
	 * 返回代码
	 */
	private String code;
	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回数据
	 */
	private String data;
	
	public ResponseBean(){}
	
	public ResponseBean(String code,String msg,String data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
