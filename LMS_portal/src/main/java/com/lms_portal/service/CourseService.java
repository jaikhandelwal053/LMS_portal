package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms_portal.entity.Course;
import com.lms_portal.repo.CourseRepo;
@Service
public class CourseService {
	@Autowired
	CourseRepo courserepo;
	
	public List<Course> allCourse(){
		return courserepo.findAll();
	}
	
	
	public List<Course> putCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return courserepo.findAll();
	}

	
	public ResponseEntity<Course> getbyid(@PathVariable Long id) {
		return ResponseEntity.ok(courserepo.findById(id).orElse(null));
	}
	
	
	public List<Course> postCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return  courserepo.findAll();
	}
	
	
	public List<Course> updateCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return  courserepo.findAll();
	}
	
	
	


}
