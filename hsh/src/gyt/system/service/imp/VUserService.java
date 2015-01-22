package gyt.system.service.imp;

import java.util.List;
import org.springframework.stereotype.Service;
import gyt.core.util.Page;
import gyt.system.model.DepartmentInfo;
import gyt.system.model.RoleInfo;
import gyt.system.model.UserInfo;
import gyt.system.service.VUserServiceInterface;

@Service("VUserService")
public class VUserService implements VUserServiceInterface{

	@Override
	public UserInfo addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findUser(String userName, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userList(Page page) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleInfo> roleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentInfo> findDepByParentId(int depId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentInfo> findSubDepByParentId(int depId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
