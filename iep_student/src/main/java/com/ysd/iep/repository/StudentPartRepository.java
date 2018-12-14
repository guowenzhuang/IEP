package com.ysd.iep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.StudentPart;

public interface StudentPartRepository extends JpaRepository<StudentPart, Integer> {
	
	public List<Integer> findBySid(String sid);

	
}
