package bond.master.Master.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bond.master.Master.model.Responsemodel;
import bond.master.Master.model.UserModel;
import bond.master.Master.repository.UserRepository;
import bond.master.Master.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	
	@Resource
	UserRepository repository;

	@Override
	public void Add(UserModel model) {
		// TODO Auto-generated method stub
		repository.save(model);
		
	}

	@Override
	public List<Responsemodel> getAll() {
		// TODO Auto-generated method stub
		 List<UserModel> listt=repository.findAll();
		List<Responsemodel> list=new ArrayList<Responsemodel>();
		
		
		
		for(UserModel model:listt) {
			
			Responsemodel m=new Responsemodel();
			m.setId(model.getId());
			m.setName(model.getFristName()+" "+model.getLastName());
			m.setEmail(model.getEmail());
			m.setDateofBirth(model.getDateofBirth());
			m.setUsername(model.getUsername());
			list.add(m);
		}
		return list;

		
		
	}

	@Override
	public UserModel getByid(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}


	@Override
	public void deleteUser(UserModel model) {
		// TODO Auto-generated method stub
		repository.delete(model);
	}
	
	
	
}
