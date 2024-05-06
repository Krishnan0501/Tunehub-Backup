package com.kodnest.example.userservice;

import com.kodnest.example.userentity.User;

public interface UserService {

	public void getuser(User user);

	public boolean emailexist(User user);

	public boolean check(String email, String password);

	public String getRole(String email);

	public User getUser(String mail);

	public void updateUser(User user);

	

	

	
	 

}
