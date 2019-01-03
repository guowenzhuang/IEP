package com.ysd.iep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
	List<Student> findBySidIn(String[] ids);
	
	/**
	 * 根据id查询学生信息
	 * @param teaid
	 * @return
	 */
	public Student findBySid(String sid);

}
