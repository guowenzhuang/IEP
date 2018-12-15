package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>, JpaSpecificationExecutor<Reply> {
	
	@Query(value = "SELECT * FROM replytb WHERE post_id=?1 AND reply_parentid=?2", nativeQuery = true)
	public Reply getPostDetails(Integer postId,Integer parentId);
	
	@Query(value = "SELECT COUNT(1) FROM liketb WHERE reply_id=?1", nativeQuery = true)
	public Integer getLikeNum(Integer replyId);
	
	@Query(value = "UPDATE replytb SET reply_likenum=?2 WHERE reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateLikeNum(Integer replyId, Integer likeNum);
	
	@Query(value = "SELECT COUNT(1) FROM reporttb WHERE reply_id=?1", nativeQuery = true)
	public Integer getReportNum(Integer replyId);
	
	@Query(value = "UPDATE replytb SET reply_reportnum=?2 WHERE reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateReportNum(Integer replyId, Integer reportNum);

	@Query(value = "INSERT INTO replytb(user_id,post_id,reply_content,reply_parentid) VALUES(?1,?2,?3,?4)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertPortDetails(String userId, Integer postId, String replyContent, Integer parentId);
	
	@Query(value = "SELECT * FROM replytb WHERE post_id=?1", nativeQuery = true)
	public List<Reply> queryPostIsReply(Integer postId);

}
