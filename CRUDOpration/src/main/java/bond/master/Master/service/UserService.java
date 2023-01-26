package bond.master.Master.service;

import java.util.List;

import bond.master.Master.model.Responsemodel;
import bond.master.Master.model.UserModel;

public interface UserService {
	
	public void Add(UserModel model);
	public List<Responsemodel> getAll();
	
	public UserModel getByid(int id);
	public void deleteUser(UserModel model);
	
	
	

}
