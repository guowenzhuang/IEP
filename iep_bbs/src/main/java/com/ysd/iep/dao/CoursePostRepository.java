package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ysd.iep.entity.CoursePost;

public interface CoursePostRepository extends  JpaRepository<CoursePost, Integer>, JpaSpecificationExecutor<CoursePost> {
	

}
