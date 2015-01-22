package gyt.system.service;

import java.util.List;

import gyt.core.util.Page;
import gyt.system.model.DepartmentInfo;
import gyt.system.model.RoleInfo;
import gyt.system.model.UserInfo;

public interface UserServiceInterface {

	public UserInfo addUser();
	
	public int deleteUser();
	
	public UserInfo updateUser();
	
	public UserInfo findUser(String userName,String pwd);
	
	public void userList(Page page);
	
	public List<RoleInfo> roleList();
	
	public List<DepartmentInfo> findDepByParentId(int depId);
	
	public List<DepartmentInfo> findSubDepByParentId(int depId);
	
}
