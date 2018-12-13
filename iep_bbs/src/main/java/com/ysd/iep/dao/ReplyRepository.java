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
	@Query(value = "UPDATE replytb SET reply_likenum=?2 WHERE reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateLikeNum(Integer replyId, Integer likeNum);

	@Query(value = "INSERT INTO replytb(user_id,post_id,reply_content,reply_parentid) VALUES(?1,?2,?3,?4)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertPort(Integer userId, Integer postId, String replyContent, Integer parentId);
	
	@Query(value = "SELECT * FROM replytb WHERE post_id=?1", nativeQuery = true)
	public List<Reply> queryPostIsReply(Integer postId);
	
	//public void deleteByPostId(Integer postId);

}
