package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	CourseRepo courserepo;
	
	
	public List<User> allUser(){
		return userrepo.findAll();
	}
	
	
	public List<Course> getEnrolledCourses(long id){
		User u = userrepo.findById(id);
		return u.getEnroll();
	}
	
	public List<User> cartCourse(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getCart();
		temp.add(c);
		u.setCart(temp);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	public List<User> enrollCourse(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getEnroll();
		temp.add(c);
		u.setEnroll(temp);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	

	public List<User> saveforlater(long user_id, long courses_id){
		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getSave_courses();
		temp.add(c);
		u.setSave_courses(temp);
		userrepo.save(u);
		return userrepo.findAll();	
	}

//	
//	public List<User> removeCartCourse(@PathVariable Long id){
//		userrepo.deleteById(id);
//		return userrepo.findAll();
//	}
	
	public List<User> putUserData(@RequestBody User u){
		userrepo.save(u);
		return userrepo.findAll();
	}

	
	public List<User> removeCartCourse(long user_id, long courses_id){

		User u = userrepo.findById(user_id);
		Course c = courserepo.findById(courses_id);
		List<Course> temp = u.getCart();
		temp.remove(c);
		u.setCart(temp);
		userrepo.save(u);
		return userrepo.findAll();	
	}
	
	public List<User> deactiveUser(@PathVariable Long id){
		userrepo.deleteById(id);
		return userrepo.findAll();
	}
	

}
