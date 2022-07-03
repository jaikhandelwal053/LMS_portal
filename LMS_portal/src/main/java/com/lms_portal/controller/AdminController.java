package com.lms_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.service.AdminService;
import com.lms_portal.service.CourseService;
import com.lms_portal.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService admin_serv;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	
//	------------------------view all user-----------------------
	@GetMapping("/user")
	public List<User> findallUser(){
		return userService.allUser();
	}
	
//	-------------------------Edit existing user-------------------
	@PutMapping("/user/update")
	public List<User> putuser(@RequestBody User u){
		return userService.putUserData(u);
	}
	
//	-------------------------Deactive existing user-------------------
	@DeleteMapping("/user/{id}/delete")
	public List<User> deleteUser(@PathVariable Long id){
		return userService.deactiveUser(id);
	}
	
//	-------------------------Add new Course-------------------
	@PostMapping("/courses/add")
	public List<Course> addnewCourse(@RequestBody Course courses){
		return courseService.postCourse(courses);
	}

//	-------------------------Update Course-------------------
	@PutMapping("/courses/update")
	public List<Course> updateCourse(@RequestBody Course courses){
		return courseService.updateCourse(courses);
	}
}
