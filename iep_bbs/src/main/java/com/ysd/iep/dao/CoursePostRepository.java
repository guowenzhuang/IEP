package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.CoursePost;

public interface CoursePostRepository extends JpaRepository<CoursePost, Integer>, JpaSpecificationExecutor<CoursePost> {

	@Query(value = "SELECT * FROM courseposttb p JOIN coursereplytb r ON p.post_id=r.post_id \r\n"
			+ "WHERE r.reply_parentid=0 AND r.course_id IN ?1 \r\n"
			+ "ORDER BY r.reply_likenum DESC,r.reply_time DESC LIMIT 5", nativeQuery = true)
	public List<CoursePost> getHotPost(List<Integer> courseIds);
	
	public CoursePost findByPostId(Integer postId);
	
	@Query(value = "UPDATE courseposttb SET reply_num=?1 WHERE post_id=?2", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateReplyNum(Integer replynum, Integer postId);

}
