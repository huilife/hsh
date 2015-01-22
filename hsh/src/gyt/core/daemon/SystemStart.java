package gyt.core.daemon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import gyt.opinterface.action.ServiceBean;
import gyt.opinterface.dao.imp.ServiceDao;
import gyt.core.util.SysControl;

/**
 * 系统后台线程启动
 */
public class SystemStart
{

    /**
     * 系统启动
     */
    public static void start(ApplicationContext beanFactory)
    {
        SysControl.setBeanFactory(beanFactory);
        //加载serviceBean
//        ServiceDao serviceDao = (ServiceDao)beanFactory.getBean("ServiceDao");
//        List<ServiceBean> serviceBeanList = (List<ServiceBean>) serviceDao.getServiceAll();
//        if(serviceBeanList != null && serviceBeanList.size() > 0){
//        	Map<String,ServiceBean> beanmap = new HashMap<String,ServiceBean>();
//    	   for(ServiceBean serviceBean : serviceBeanList){
//    		   beanmap.put(""+serviceBean.getCode(), serviceBean);
//    		   System.out.println("==========="+serviceBeanList.get(0).getModelName());
//           } 
//    	   SysControl.setServiceFactory(beanmap);
//        }
//        System.out.println("=====ssssssssssssssssssss======"+serviceBeanList.get(0).getModelName());
//        System.out.println("=====ssssssssssssssss======"+serviceBeanList.get(0).getModelName());
//        System.out.println("=====ssssssssssssssssss======"+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
//        System.out.println("==========="+serviceBeanList.get(0).getModelName());
    }

    /**
     * 系统停止
     */
    public static void destroy(ApplicationContext beanFactory)
    {
        /** begin modified by wuwei in 20130109 **/
        /** end modified by wuwei in 20130109 **/
    }

}
