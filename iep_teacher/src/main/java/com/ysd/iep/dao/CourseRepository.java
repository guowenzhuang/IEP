package com.ysd.iep.dao;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

	/**
	 * 分页查询课程(前台)
	 * @param DepId
	 * @param pageable
	 * @return Page<Course>
	 */
	public Page<Course> findByCourDepid(String DepId,Pageable pageable);
}
