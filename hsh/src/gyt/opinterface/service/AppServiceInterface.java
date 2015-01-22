package gyt.opinterface.service;

import gyt.opinterface.model.RequestBean;
import gyt.opinterface.model.ResponseBean;

/**
 * 业务处理入口
 * @author yangyuanjiang
 * @version 2014-08-05
 */
public interface AppServiceInterface {
	
	public ResponseBean execute(RequestBean requestBean);
}
