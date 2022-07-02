package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.User;
import com.lms_portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	

//	------------------------view all user-----------------------
	@GetMapping("/")
	public List<User> findallUser(){
		return userService.allUser();
	}
	
	
//	------------------------Add new user-------------------------
	@PostMapping("/addnew")
	public List<User> postuser(@RequestBody User u){
		return userService.postUserData(u);
	}
	
//	-------------------------Edit existing user-------------------
	@PutMapping("/update")
	public List<User> putuser(@RequestBody User u){
		return userService.putUserData(u);
	}
	
}
