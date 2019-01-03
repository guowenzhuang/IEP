package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Reply;


public interface CourseReplyRepository extends JpaRepository<CourseReply, Integer>{
	
	@Query(value = "SELECT * FROM coursereplytb WHERE post_id=?1 AND reply_parentid=?2", nativeQuery = true)
	public CourseReply getPostDetails(Integer postId, Integer parentId);
	
	@Query(value = "SELECT COUNT(1) FROM courseliketb WHERE reply_id=?1", nativeQuery = true)
	public Integer getLikeNum(Integer replyId);
	
	@Query(value = "UPDATE coursereplytb SET reply_likenum=?2 WHERE reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateLikeNum(Integer replyId, Integer likeNum);
	
	@Query(value = "INSERT INTO coursereplytb(course_id,user_id,post_id,reply_content,reply_parentid) VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertPortDetails(Integer courseId,String userId, Integer postId, String replyContent, Integer parentId);
	
	@Query(value = "UPDATE coursereplytb SET reply_browse=reply_browse + 1  WHERE  reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateBrowse(Integer replyId);
		
	@Query(value = "SELECT reply_id FROM coursereplytb WHERE post_id=?1 AND reply_parentid=?2 ", nativeQuery = true)
	public Integer queryReplyIdByPostIdAndParentId(Integer postId, Integer parentId);
	
	@Query(value = "SELECT * FROM coursereplytb WHERE post_id=?1 AND reply_parentid>0 ORDER BY reply_time DESC", nativeQuery = true)
	public List<CourseReply> queryReplyByPostId(Integer postId);
	
	@Query(value = "SELECT user_id FROM coursereplytb WHERE reply_id=?1", nativeQuery = true)
	public String queryUserIdByReplyId(Integer replyId);
	
	@Query(value = "SELECT COUNT(1) FROM courseliketb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	public Integer userIsLike(String userId, Integer replyId);
	
	@Query(value = "INSERT INTO courseliketb(user_id,reply_id) VALUES(?2,?1)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer replyLike(Integer replyId, String userId);
	
	@Query(value = "DELETE FROM courseliketb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer deleteLike(String userId, Integer replyId);
	
	@Query(value = "SELECT COUNT(1) FROM coursereplytb r WHERE r.reply_parentid <> 0 AND  r.post_id=?1", nativeQuery = true)
	public Integer getReplyNum(Integer postId);
	
	@Query(value = "SELECT COUNT(1) FROM coursereplytb WHERE course_id=?1", nativeQuery = true)
	public Integer getCoursePostNum(Integer courseId);
}
