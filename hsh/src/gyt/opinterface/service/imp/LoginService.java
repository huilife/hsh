package gyt.opinterface.service.imp;

import org.springframework.stereotype.Service;
import gyt.opinterface.model.RequestBean;
import gyt.opinterface.model.ResponseBean;
import gyt.opinterface.service.AppServiceInterface;

@Service("LoginService")
public class LoginService implements AppServiceInterface{

	@Override
	public ResponseBean execute(RequestBean requestBean) {
		// TODO Auto-generated method stub
		return new ResponseBean("1","OK","{'name':'zhangsan'}");
	}

	

}
