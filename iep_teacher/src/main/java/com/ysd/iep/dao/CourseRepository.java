package com.ysd.iep.dao;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

	/**
	 * 分页查询  课程(前台)
	 * @param DepId
	 * @param pageable
	 * @return Page<Course>
	 */
	public Page<Course> findByCourDepidLike(String DepId,Pageable pageable);

	/**
	 * 提供  根据课程id查询课程信息
	 * @return
	 */
	@Query(value="select * from coursetb where cour_id in (?1) ",nativeQuery=true)
	public Course findByCourseId(Integer courId);
	/**
	 * 根据教师Id查询课程
	 * @param teaId
	 * @return
	 */

	public List<Course> findByCourTeaid(String teaId);
	/**
	 *
	 *//*
	@Transactional
	@Modifying
	@Query(value="update  coursetb set cour_name=#{#course.cour_name},cour_price=#{#course.cour_price},cour_details=#{#course.cour_details} where cour_id=#{#course.cour_id} ",nativeQuery=true)
	int updateCourse(Course course);*/
}
