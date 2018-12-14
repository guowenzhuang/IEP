package com.ysd.iep.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.StudentComment;
/**
 * 评价接口
 * @author ASUS
 *
 */
public interface CommentRepository extends JpaRepository<StudentComment, Integer>,JpaSpecificationExecutor<StudentComment>{
	
	
	
}
