package com.relation.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.onetomany.entity.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course,Integer>{

}
