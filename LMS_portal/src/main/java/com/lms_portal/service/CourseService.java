package com.lms_portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	public List<Course> postCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return courserepo.findAll();
	}
	
	public List<Course> putCourse(@RequestBody Course courses){
		courserepo.save(courses);
		return courserepo.findAll();
	}

}
