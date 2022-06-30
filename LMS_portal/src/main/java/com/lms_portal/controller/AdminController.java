package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService admin_serv;
	
//	------------------------view all user-----------------------
	@GetMapping("/user/")
	public List<User> findallUser(){
		return admin_serv.allUser();
	}
//	------------------------Add new user-------------------------
	@PostMapping("/user/")
	public List<User> postuser(@RequestBody User u){
		return admin_serv.postUserData(u);
	}
//	-------------------------Edit existing user-------------------
	@PutMapping("/user/")
	public List<User> putuser(@RequestBody User u){
		return admin_serv.putUserData(u);
	}
	
//	--------------------------Add new Courses------------------------
	@PostMapping("/course")
	public List<Course> addnewCourse(@RequestBody Course corses){
		return admin_serv.postCourse(corses);
	}
	
//	--------------------------Edit course detail---------------------
	@PutMapping("/course/")
	public List<Course> postCourse(@RequestBody Course corses){
		return admin_serv.postCourse(corses);
	}

}
