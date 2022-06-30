package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Admin;
import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.repo.AdminRepo;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.repo.UserRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo adminrepo;
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	CourseRepo courserepo;
	
	
//-----------------------Admin --------------------------------------
	public List<Admin> get() {
		return adminrepo.findAll();
		
	}
//-----------------------User data-----------------------------------
	
	public List<User> allUser(){
		return userrepo.findAll();
	}
	public List<User> postUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
		
	}
	public List<User> putUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
		
	}
	
//---------------------Course Operation----------------------------
	
	public List<Course> allCourse(){
		return courserepo.findAll();
	}
	
	public List<Course> postCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return courserepo.findAll();
	}
	public List<Course> putCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return courserepo.findAll();
	}

}
