package com.ysd.iep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.StudentPart;

public interface StudentPartRepository extends JpaRepository<StudentPart, Integer> {

	
}
