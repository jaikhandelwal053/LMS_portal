package com.lms_portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms_portal.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
