package com.ysd.iep.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ysd.iep.entity.CoursePost;
import com.ysd.iep.entity.CoursePostQuery;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Reply;

public interface CoursePostService {
	
	public Page<CoursePost> queryAllCoursePost(CoursePostQuery postQuery, Pageable pageable);
	
	public CourseReply getPostDetails(Integer postId, Integer parentId);
	
	public Integer getLikeNum(Integer replyId);

}
