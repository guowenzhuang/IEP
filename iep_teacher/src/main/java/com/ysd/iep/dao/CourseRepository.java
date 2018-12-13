package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {


}
