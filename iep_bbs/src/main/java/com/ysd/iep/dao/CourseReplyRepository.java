package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.CourseReply;


public interface CourseReplyRepository extends JpaRepository<CourseReply, Integer>{
	
	@Query(value = "SELECT * FROM coursereplytb WHERE post_id=?1 AND reply_parentid=?2", nativeQuery = true)
	public CourseReply getPostDetails(Integer postId, Integer parentId);
	
	@Query(value = "SELECT COUNT(1) FROM courseliketb WHERE reply_id=?1", nativeQuery = true)
	public Integer getLikeNum(Integer replyId);

}
