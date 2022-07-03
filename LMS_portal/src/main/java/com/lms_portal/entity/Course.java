package com.lms_portal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String course_name;
	
	@Column
	private String time_duration;
	
	@Column
	private String description;
	
	@Column
	private int price;
	
	@ManyToOne
	Admin admin;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

public Course(long id, String course_name, String time_duration, String description, int price, Admin admin) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.time_duration = time_duration;
		this.description = description;
		this.price = price;
		this.admin = admin;
	}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getCourse_name() {
	return course_name;
}

public void setCourse_name(String course_name) {
	this.course_name = course_name;
}

public String getTime_duration() {
	return time_duration;
}

public void setTime_duration(String time_duration) {
	this.time_duration = time_duration;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@JsonBackReference
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}




}
