package com.kodnest.example.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.example.userentity.User;
import com.kodnest.example.userrepository.UserRepository;
import com.kodnest.example.userservice.UserService;
@Service 
public class UserImplement implements UserService {
	@Autowired
	UserRepository userrepository;

	@Override
	public void getuser(User user) {
		userrepository.save(user);

	}

	@Override
	public boolean emailexist(User user) {
		User exist=userrepository.findByEmail(user.getEmail());
		if(exist!=null) {
			System.out.println("Present");
				
			return true;
		}
		else {
			System.out.println("Absent");
			return false;
		}
	}
	@Override
	public boolean check(String email, String password) {
	      User CorrectEmail = userrepository.findByEmail(email);
	    if (CorrectEmail != null) {
	        String CorrectPassword = CorrectEmail.getPassword();
	        if (CorrectPassword.equals(password)) {
	            return true;
	        }
	    }
	    return false;
	}


	@Override
	public String getRole(String email) {
		User roleofuser=userrepository.findByEmail(email);
		
		return roleofuser.getRole();
		
	}

	@Override
	public User getUser(String mail) {
		
		return userrepository.findByEmail(mail);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userrepository.save(user);
	}

	
			


	


}
