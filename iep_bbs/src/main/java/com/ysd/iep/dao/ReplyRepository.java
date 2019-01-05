package com.ysd.iep.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>, JpaSpecificationExecutor<Reply> {

	@Query(value = "SELECT * FROM replytb WHERE post_id=?1 AND reply_parentid=?2", nativeQuery = true)
	public Reply getPostDetails(Integer postId, Integer parentId);

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

	@Query(value = "SELECT * FROM replytb WHERE post_id=?1 AND reply_parentid>0 ORDER BY reply_time DESC", nativeQuery = true)
	public List<Reply> queryReplyByPostId(Integer postId);

	@Query(value = "SELECT reply_id FROM replytb WHERE post_id=?1 AND reply_parentid=?2 ", nativeQuery = true)
	public Integer queryReplyIdByPostIdAndParentId(Integer postId, Integer parentId);

	@Query(value = "UPDATE replytb SET reply_browse=reply_browse + 1  WHERE  reply_id=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer updateBrowse(Integer replyId);

	@Query(value = "INSERT INTO liketb(user_id,reply_id) VALUES(?2,?1)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer replyLike(Integer replyId, String userId);

	@Query(value = "SELECT COUNT(1) FROM liketb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	public Integer userIsLike(String userId, Integer replyId);
	
	@Query(value = "DELETE FROM liketb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer deleteLike(String userId, Integer replyId);

	@Query(value = "INSERT INTO replytb(reply_content,reply_parentid,post_id,user_id) VALUES(?1,?2,?3,?4)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer insertReply(String replyContent, Integer parentId, Integer postId, String userId);
	
	@Query(value = "SELECT COUNT(1) FROM reporttb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	public Integer userIsReport(String userId,Integer replyId);
	
	@Query(value = "INSERT INTO reporttb(user_id,reply_id,report_reason) VALUES(?1,?2,?3)", nativeQuery = true)
	@Modifying
	@Transactional
	public Integer userReport(String userId,Integer replyId,String reportReason);
	
	@Query(value = "SELECT user_id FROM replytb WHERE reply_id=?1", nativeQuery = true)
	public String queryUserIdByReplyId(Integer replyId);
	
	//软删除
	@Query(value="UPDATE replytb SET is_delete=1 WHERE reply_id=?1",nativeQuery= true)
	@Modifying
	@Transactional
	public Integer upReplyIsDel(Integer replyId);
	
	@Query(value="UPDATE replytb SET is_delete=0 WHERE reply_id=?1",nativeQuery= true)
	@Modifying
	@Transactional
	public Integer upReplyIsDelO(Integer replyId);
	
	@Query(value = "SELECT COUNT(1) FROM replytb r WHERE r.reply_parentid <> 0 AND  r.post_id=?1", nativeQuery = true)
	public Integer getReplyNum(Integer postId);
	
	@Query(value = "SELECT * FROM replytb WHERE reply_parentid=0 AND post_id IN (?1)", nativeQuery = true)
	public List<Reply> getPostList(List<Integer> postIds);
	
	@Query(value = "SELECT COUNT(1),reply_id FROM liketb WHERE reply_id IN (?1)\r\n" +
			"GROUP BY reply_id", nativeQuery = true)
	public List<Integer> getLikeNumList(List<Integer> replyIds);
	
	@Query(value = "SELECT COUNT(1) FROM reporttb WHERE reply_id IN (?1)\r\n" + 
			"GROUP BY reply_id", nativeQuery = true)
	public List<Integer> getReportNumList(List<Integer> replyIds);
	
	@Query(value = "SELECT COUNT(1) FROM replytb WHERE post_id IN (?1) AND reply_parentid<>0\r\n" + 
			"GROUP BY post_id", nativeQuery = true)
	public List<BigInteger> getReplyNumList(List<Integer> postIds);

	@Modifying
	@Transactional
	@Query(value = "update Reply set replyLikenum=replyLikenum+1 where replyId=:replyId")
	void addLike(@Param("replyId") Integer replyId);
	@Modifying
	@Transactional
	@Query(value = "update Reply set replyReportnum=replyReportnum+1 where replyId=:replyId")
	void addReplyReportnum(@Param("replyId") Integer replyId);

	@Modifying
	@Transactional
	@Query(value = "update Reply set replyLikenum=replyLikenum-1 where replyId=:replyId")
	void reduceLike(@Param("replyId") Integer replyId);
	@Modifying
	@Transactional
	@Query(value = "update Reply set replyReportnum=replyReportnum-1 where replyId=:replyId")
	void reduceReplyReportnum(@Param("replyId") Integer replyId);

}
