package com.rakuten.services;

import java.util.List;

import com.rakuten.Entities.Course;
public interface CourseService {

	public Course getCourse(long courseId);
	public List<Course> getCourses();
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public Course deleteCourse(long courseId);
}
