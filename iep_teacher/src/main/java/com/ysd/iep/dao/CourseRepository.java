package com.ysd.iep.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {

	@Query(value="FROM Course WHERE courTeaid in(:teaids)")
	List<Course> findBycourTeaid(@Param("teaids") String[] teaids);
	
	
	

	/**
	 * 提供根据课程id查询单个课程信息
	 * @return
	 */
	@Query(value="select * from coursetb where cour_id=?1 ",nativeQuery=true)
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

	/**
	 * 根据课程id查询章节id
	 * @param
	 * @return
	 */
	@Query(value = "select cha_id from chaptertb where  cha_courid=?1 ", nativeQuery = true)
	Integer queryChaCourid(Integer chaCourId);

	@Query(value = "select * from coursetb where cour_teaid in(:ids)",nativeQuery = true)
	Page<Course> findByteaIds(@Param("ids") String ids, Pageable pageable);

}
