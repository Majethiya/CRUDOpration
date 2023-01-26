package bond.master.Master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bond.master.Master.model.UserModel;

@Repository 
public interface UserRepository  extends JpaRepository<UserModel, Integer>{
	
	
	public UserModel findById(int id);

}
