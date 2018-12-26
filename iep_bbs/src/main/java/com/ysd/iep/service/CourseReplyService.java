package com.ysd.iep.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ysd.iep.entity.CourseReply;

public interface CourseReplyService {
	
	public Page<CourseReply> queryAllReply(String userId,Integer courseId,Pageable pageable); 

}
