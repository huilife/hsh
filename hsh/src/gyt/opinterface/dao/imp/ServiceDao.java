package gyt.opinterface.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gyt.core.dao.DatabaseDao;
import gyt.opinterface.action.ServiceBean;
import gyt.opinterface.mapping.ServiceMapper;

@Repository("ServiceDao")
public class ServiceDao extends DatabaseDao{

	private ServiceMapper serviceMapper;
	
	public ServiceDao() {
		super(ServiceBean.class.getName());
	}
	
	public List<ServiceBean> getServiceAll(){
		return serviceMapper.selectServiceAll();
	}
	
	@Autowired
	public void setServiceMapper(ServiceMapper serviceMapper) {
		this.serviceMapper = serviceMapper;
	}
}
