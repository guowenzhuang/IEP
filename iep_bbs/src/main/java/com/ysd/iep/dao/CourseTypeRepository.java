package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.CourseType;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer>{
	
	@Query(value = "INSERT INTO courseposttypetb(post_id,type_id) VALUES(?1,?2)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertPosttype(Integer postId,Integer typeId);

}
