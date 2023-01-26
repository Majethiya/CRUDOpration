package bond.master.Master.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bond.master.Master.model.UserModel;
import bond.master.Master.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping("/add")
    public String hello(HttpSession session,
    		@RequestParam(value="fristName") String fristName,
    		@RequestParam(value = "lastName")String lastName,
    		@RequestParam(value = "dateofBirth")String dateofBirth,
    		@RequestParam(value = "username")String username,
    		@RequestParam(value = "password")String password,
    		@RequestParam(value = "email")String email,
    		@RequestParam(value = "flag")String flag,
    		@RequestParam(value = "editid")String editid
    		)
	    {
		
		System.out.println("flag"+flag);
		System.out.println("editid"+editid);
		
		
		if(flag.equalsIgnoreCase("1")) {
			System.out.println("in edit"+editid);
			System.out.println("in edit"+email);
			
			
			UserModel model2=userservice.getByid(Integer.parseInt(editid));
			model2.setFristName(fristName);
			model2.setLastName(lastName);
			model2.setDateofBirth(dateofBirth);
			model2.setUsername(username);
			model2.setPassword(password);
			model2.setEmail(email);
			
			userservice.Add(model2);
			session.setAttribute("list",userservice.getAll());
		return "users";
		
		}else {
		
		
		UserModel model2 = new UserModel();
		model2.setFristName(fristName);
		model2.setLastName(lastName);
		model2.setDateofBirth(dateofBirth);
		model2.setUsername(username);
		model2.setPassword(password);
		model2.setEmail(email);
		
		userservice.Add(model2);
		session.setAttribute("list",userservice.getAll());
	
		return "users";
		}
		
	}
	@GetMapping("/list")
	
	public String list(HttpSession session) {	
		session.setAttribute("list",userservice.getAll());
		return "users";
	}
	
	
	
	
	
	 @RequestMapping(value="/getUserById", method = RequestMethod.GET)
	  
	    public String  home(ModelMap model,@RequestParam Integer id,HttpSession  session){
		 
		 
		 System.out.println(""+userservice.getByid(id).getFristName());
		 
		 session.setAttribute("user",userservice.getByid(id));
		 session.setAttribute("flag","1"); 
		 session.setAttribute("editid",id); 
		 
		 return "NewEdit";
		 
	 }
	
	 
	 @RequestMapping(value="/deleteUser", method = RequestMethod.GET)
	  
	    public String  deleteUser(ModelMap model,@RequestParam Integer id,HttpSession  session){
		 
		 
		
		UserModel model2= userservice.getByid(id);
		userservice.deleteUser(model2);
		 
		session.setAttribute("list",userservice.getAll());
		 session.setAttribute("flag","1"); 
		 return "users";
	 }
	 
	 
	 
	 
	
   
	
	
	
	
	
	@GetMapping("/")
	public String  getUser(ModelMap model,HttpSession session) {
		System.out.println("in get pge");
		 session.setAttribute("flag","0"); 
		return "NewEdit";
		
	}

}
