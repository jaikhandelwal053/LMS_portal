package com.lms_portal.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms_portal.entity.Course;
import com.lms_portal.entity.User;
import com.lms_portal.repo.CourseRepo;
import com.lms_portal.repo.UserRepo;
@Service
public class CourseService {
	@Autowired
	CourseRepo courserepo;
	
	@Autowired
	UserRepo userrepo;
	
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
	
	public List<Course> getEnrolledCourses(long id){
		User u = userrepo.findById(id);
		return u.getEnroll();
	}


	public List<Course> deleteCourse(@PathVariable Long id) {
		courserepo.deleteById(id);
		return courserepo.findAll();
	}

	public List<Course> getCourseByName(@RequestParam String courseName){
		List<Course> listcourse = courserepo.findByNameCourse(courseName);
		return listcourse;
	}

	public List<Course> getCourseByPriceRange(@RequestParam Double lrange,@RequestParam Double hrange) {
		List<Course> listcourserange = courserepo.findByRange(lrange,hrange);
		return listcourserange;
	}

     

}
