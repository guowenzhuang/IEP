package com.ysd.iep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	

}
