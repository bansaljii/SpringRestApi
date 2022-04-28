package com.rakuten.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakuten.Entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
