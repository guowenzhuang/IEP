package com.ysd.iep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
	List<Student> findBySidIn(String[] ids);
	
	/**
	 * 根据id查询学生信息
	 * @param teaid
	 * @return
	 */
	public Student findBySid(String sid);


	@Query(value = "UPDATE studenttb SET credits=credits+?1 WHERE sid=?2",nativeQuery=true)
	@Modifying
	@Transactional
	public void updateCredits(Integer credits,String sid);

}
