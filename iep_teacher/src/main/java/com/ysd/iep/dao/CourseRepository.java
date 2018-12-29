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
	 * 提供  根据课程id查询课程信息
	 * @return
	 */
	@Query(value="select * from coursetb where cour_id in (?1) ",nativeQuery=true)
	public Course findByCourseId(Integer courId);

	@Query(value="select * from coursetb where cour_id in (?1) ",nativeQuery=true)
	List<Course> findByCourseIds(String[] courIds);
	/**
	 * 根据教师Id查询课程
	 * @param teaId
	 * @return
	 */

	public List<Course> findByCourTeaid(String teaId);

	/**
	 * 根据课程id修改报名人数
	 * @param courId
	 */
	@Query(value = "UPDATE coursetb SET cour_studypeople=cour_studypeople+1 WHERE cour_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	 public void updateCourStudypeople(Integer courId);

	/**
	 * 根据院系Id查询课程(根据报名人数降序取前六个)
	 * @param teaids
	 * @return
	 */
	@Query(value = "SELECT * FROM  coursetb WHERE cour_teaid in( ?1)  ORDER BY cour_studypeople DESC LIMIT 6",nativeQuery = true)
	public List<Course> queryCourByDepId(List<String> teaids);

	List<Course> findByCourTeaidIn(List<String> teaid);


}
