package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Cart;
import com.lms_portal.entity.User;
import com.lms_portal.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	
	public List<User> allUser(){
		return userrepo.findAll();
	}
	
	public List<User> postUserData(@RequestBody User u){
		if(u.getCart() == null ) {
		u.setCart(new Cart());
		}
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	public List<User> putUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
	}

}
