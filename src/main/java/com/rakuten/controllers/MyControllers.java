package com.rakuten.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.Entities.Course;
import com.rakuten.services.CourseService;
import com.rakuten.services.CourseServiceImpl;

@RestController
public class MyControllers {
	
	//here we create an object of courseserviceimpl by the help of dependency injection use @autowired annotation
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Abhishek Bansal";
	}
	

	//this return the complete list of courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//this is used to return the particular coursed on the basic of courseId
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return courseService.getCourse(Long.parseLong(courseId));
	}
	
	//here we have to pass our object of course class by the help of json data Adding data 
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return courseService.addCourse(course);
	}
	
	//Update course
	@RequestMapping(path = "/courses" , method = RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course course)
	{
		
		return courseService.updateCourse(course);
		
	}

	
	//delete the course for the particular Id
	
	
//	@DeleteMapping("/course/{courseId}")
//	public Course deleteCoursee(@PathVariable String courseId) {
//		return courseService.deleteCourse(Long.parseLong(courseId));
//	}
	
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			System.out.println("Method is executed deletecourse controllers");
			courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
