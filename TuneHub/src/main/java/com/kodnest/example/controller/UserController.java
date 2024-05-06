package com.kodnest.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.example.userentity.Song;
import com.kodnest.example.userentity.User;
import com.kodnest.example.userservice.SongService;
import com.kodnest.example.userservice.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	SongService songservice;
	@PostMapping("/register")
	public String userdata(@ModelAttribute User user) {
		boolean exist=userservice.emailexist(user);
		if(exist==false) {	
			userservice.getuser(user);
			System.out.println("Successfully Regisstered");
		}
		else {
			System.out.println("Email already registered");
		}

		return  "login";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model) {
		boolean checked=userservice.check(email,password); 
		System.out.println(email+"     "+password+"======="+"login");
		if(checked==true) {
			session.setAttribute("email",email);
			String roles=userservice.getRole(email);
			if(roles.equals("admin")){
				System.out.println("Welcome Admin Home Page");
				return "adminhome";
			}
			else {
				System.out.println("Welcome Customer Home Page");
				User user = userservice.getUser(email);
				boolean userstatus=user.isPremium();
				if(userstatus) {
					List<Song> fetchallsongs=songservice.fetchAllSongs();
					model.addAttribute("songs",fetchallsongs);
					model.addAttribute("ispremium",userstatus);
					return "viewsongs";
				}
			
				
			}
				return "customerhome";
			}
		
		else {System.out.println("Credentials Missmatch");}

		return "login";
	}
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	

}
