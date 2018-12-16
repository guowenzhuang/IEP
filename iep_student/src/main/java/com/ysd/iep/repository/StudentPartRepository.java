package com.ysd.iep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.StudentPart;
import com.ysd.iep.entity.StudentPartCid;

public interface StudentPartRepository extends JpaRepository<StudentPart, Integer> {
	
	@Query(value=" SELECT s.cid FROM StudentPart as s ")
	public List<StudentPartCid> findBySid(String sid);

	//报名此课程的人数
	@Query(value=" SELECT COUNT(*) FROM  StudentPart s WHERE s.cid=?1 ")
	public int count(Integer cid);
	

	
}
