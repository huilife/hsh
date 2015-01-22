package gyt.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import gyt.opinterface.action.ServiceBean;

public class SysControl
{
	public static final String PAGE_PATH = "/WEB-INF/page/";
	
	public static final String USER_SESSION = "userinfo";
	
	public static final String VERSION_DLY = "0";
	
	public static String contextName;
	
	public static String webPath;
	
	public static String realPath;
	
	public static int webPort;
	
	public static String filePath = FileUtil.class.getResource("").toString().substring(6, FileUtil.class.getResource("").toString().indexOf("WEB-INF/"));
	
	public static String dateFilePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	 /**
     * 自定义执行或查询key，但处理的sql在本dao的命名空间之内
     */
    public static final String DAO_METHOD_KEY = "dao_method_key";
    /**
     * 全局自定义执行key,只有baseDao调用，其他业务无需调用
     */
    public static final String DEFAULT_SQL_EXECUTE = "Global.execute";
    /**
     * 全局自定义查询单个结果key,只有baseDao调用，其他业务无需调用
     */
    public static final String DEFAULT_SQL_QUERY_ONE = "Global.queryOne";
    /**
     * 全局自定义查询结果集key,只有baseDao调用，其他业务无需调用
     */
    public static final String DEFAULT_SQL_QUERY_LIST = "Global.queryList";
    
    public static ApplicationContext beanFactory;
    
    public static Map<String,ServiceBean> serviceFactory;

	public static String UPLOAD_FILEPATH = "";

    public static void setBeanFactory(ApplicationContext beanFactory)
    {
        SysControl.beanFactory = beanFactory;
    }
    
    public static void setServiceFactory(Map<String,ServiceBean> serviceFactory)
    {
        SysControl.serviceFactory = serviceFactory;
    }
    
    public static ServiceBean getServiceBean(String code){
    	 return SysControl.serviceFactory.get(code);
    }

    /**
     * 获取spring环境中的bean
     * 
     * @param clazz
     *            实体bean的类型
     * 
     * @return T 实体对象
     */
    public static <T> T getBean(Class<T> clazz)
    {
        return beanFactory.getBean(clazz);
    }

    /**
     * 获取spring环境中的bean
     * 
     * @param beanName
     *            实体bean的名称
     * @param clazz
     *            实体bean的类型
     * 
     * @return T 实体对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> clazz)
    {
        return (T) beanFactory.getBean(beanName);
    }

}
