package com.lms_portal.controller;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lms_portal.service.CourseService;
import com.lms_portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;
	
//  Get all Courses
	@GetMapping("/courses")
	public List<Course> getall(){
		return courseService.allCourse();
	}
	
//	Get Order LIst
		@GetMapping("/{id}/enrolled_courses")
		public List<Course> getEnrolled(@PathVariable Long id){
			return userService.getEnrolledCourses(id);
		}
	
		
//add to cart 
		@PostMapping("/cart/add")
		public List<User> postCart(@RequestBody JsonNode requestBody){

			return userService.cartCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}
		

//Enroll courses
	@PostMapping("/enroll_courses")
	public List<User> postdata(@RequestBody JsonNode requestBody){
		return userService.enrollCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
	}
	
	
//Save for later courses
		@PostMapping("/save_course")
		public List<User> saveCourse(@RequestBody JsonNode requestBody){
			return userService.saveforlater(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
		}

		
		
//	@PutMapping("/enroll_courses")
//	public List<User> update(@RequestBody User u){
//		return userService.allUser();
//	}
		
//	------------------------view all user-----------------------
	@GetMapping("/")
	public List<User> findallUser(){
		return userService.allUser();
	}
	
//	Delete Course from Cart
	@DeleteMapping("/cart/courses")
	public List<User> removeCart(@RequestBody JsonNode requestBody){

		return userService.removeCartCourse(requestBody.get("user_id").asLong(), requestBody.get("courses_id").asLong());
	}
	
}
	

