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
import com.lms_portal.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseService courseService;
	

	@GetMapping("/")
	public List<Course> getall(){
		return courseService.allCourse();
	}
	
//	--------------------------Add new Courses------------------------
	@PostMapping("/")
	public List<Course> addnewCourse(@RequestBody Course courses){
		return courseService.postCourse(courses);
	}
	
//	--------------------------Edit course detail---------------------
	@PutMapping("/")
	public List<Course> updateCourse(@RequestBody Course courses){
		return courseService.putCourse(courses);
	}
	
}
