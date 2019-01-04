package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.TeacherDTO;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teachers, String> , JpaSpecificationExecutor<Teachers> {

	@Query(value = "SELECT tea_id FROM teachertb WHERE tea_departmentid=:ids",nativeQuery = true)
	List<String> findByteaIds(@Param("ids") String ids);
	
	
	@Query(value = "from Teachers where teaId in (:ids)")
	List<Teachers> findById(@Param("ids") String[] ids);
	@Query(value = "INSERT INTO teachertb (tea_id)VALUES(?1)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer addTecherById(String teaid);
	/**
	 * 所有查询教师Id
	 * @return
	 */
	@Query(value = "SELECT tea_id FROM teachertb", nativeQuery = true)
	public List<String> queryTeacherId();
	
	/**
	 * 根据id查询老师信息
	 * @param teaid
	 * @return
	 */
	public Teachers findByTeaId(String teaid);
	
	@Modifying
	@Query(value = "UPDATE teachertb SET tea_describe=:describe,tea_talk=:teatalk,tea_sex=:teasex  WHERE tea_id=:teaid",nativeQuery = true)
	public void  updateTeacher(@Param("describe")String teadescribe,@Param("teatalk")String teatalk,@Param("teasex")String teasex,@Param("teaid")String teaid);

	/**
	 * 根据院系id查找所有老师
	 * @param teaDepartmentid
	 * @return
	 */
	List<Teachers> getByTeaDepartmentid(String teaDepartmentid);
	
}
