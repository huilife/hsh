package gyt.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
/**
 * 动态获取bean
 * @author yangyuanjiang
 * @version 2014-08-05
 */
public class SpringBeanFactoryUtils implements BeanFactoryAware {  
	  
    private static BeanFactory beanFactory = null;  
    private static SpringBeanFactoryUtils factoryUtils = null;  
    
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {  
        SpringBeanFactoryUtils.beanFactory = beanFactory;  
    }  
    public static BeanFactory getBeanFactory() {  
        return beanFactory;  
    }  
    public static SpringBeanFactoryUtils getInstance(){  
        if(factoryUtils==null){  
            //factoryUtils = (SpringBeanFactoryUtils)beanFactory.getBean("springBeanFactoryUtils");  
            factoryUtils = new SpringBeanFactoryUtils();  
        }  
        return factoryUtils;  
    }  
    
    public static Object getBean(String code){  
    	String name = code;
        return beanFactory.getBean(name);  
    }  
    
}  