package gyt.opinterface.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import gyt.core.util.SysControl;
import gyt.opinterface.model.RequestBean;
import gyt.opinterface.model.ResponseBean;
import gyt.opinterface.service.AppServiceInterface;
import gyt.core.util.ServiceKeyUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.*;

@Controller
@RequestMapping("/main")
public class MainAction {
	
	private static final Logger logger = Logger.getLogger(MainAction.class);
	
	private AppServiceInterface appService;
	
	/**
	 * app接口调用 统一入口
	 * @param json
	 */
	@RequestMapping("/execute")
	public @ResponseBody ResponseBean execute(String json,HttpServletRequest request,HttpServletResponse response){
		logger.info(" MainAction execute !!!");
		RequestBean requestBean = JSONObject.toJavaObject(JSON.parseObject(json), RequestBean.class);
		ResponseBean responseBean = null;
		/** 验证密匙 */
		if(!ServiceKeyUtil.isValidation(requestBean)){
			/** 调用业务处理 */
			responseBean = this.getServiceMethod(requestBean);
		}else{
			/** 返回失败信息 */
			responseBean = new ResponseBean("0", "密匙验证失败", "");
		}
		/** 返回信息 */
		return responseBean;
	}
	
	/**
	 * 调用相关业务方法
	 * @param requestBean
	 * @return
	 */
	public ResponseBean getServiceMethod(RequestBean requestBean){
		ResponseBean responseBean = null;
		Method method = null;
		try {
			System.out.println(requestBean.getCode());
			ServiceBean serviceBean = SysControl.getServiceBean(requestBean.getCode());
			appService = (AppServiceInterface)SysControl.beanFactory.getBean(serviceBean.getModelName());
			method = appService.getClass().getDeclaredMethod(serviceBean.getModelMethod(), RequestBean.class);
			responseBean = (ResponseBean)method.invoke(appService, requestBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseBean;
	}
}
