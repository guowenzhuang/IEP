package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

import com.ysd.iep.entity.Teachers;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teachers, String> , JpaSpecificationExecutor<Teachers> {

	@Query(value = "INSERT INTO teachertb (tea_id)VALUES(?1)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer addTecherById(String teaid);

	
}
