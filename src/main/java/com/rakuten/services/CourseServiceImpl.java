package com.rakuten.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rakuten.Entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> list ;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145,"Java course ","this course contain all syallabus of java"));
		list.add(new Course(434,"Spring Boot course","this courser contain rest api using spring boot"));

		list.add(new Course(145,"Java course ","this course contain all syallabus of java"));
		list.add(new Course(434,"Spring Boot course","this courser contain rest api using spring boot"));
	}

	
	@Override
	public List<Course> getCourses() {
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course : list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		list.forEach(corse -> System.out.println(corse));
		return c;
	}


	
	//this is used to add course in our list
	@Override
	public Course addCourse(Course course) {
	
		list.add(course);
		list.forEach(c-> {
			System.out.println(c);
		});
		list.forEach(corse -> System.out.println(corse));
		return course;
	}


	//override of update course method main logic
	@Override
	public Course updateCourse(Course course) {
		
		list.forEach(e -> 
		{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});
		list.forEach(corse -> System.out.println(corse));

		return course;
	}


	@Override
	public Course deleteCourse(long courseId) {
		Course c = null;
		for(Course course : list) {
			if(course.getId() == courseId) {
				c=course;
				list.remove(course);
			}
		}
		list.forEach(course -> System.out.println(course));
		return c;
		
	}
	
	
}
