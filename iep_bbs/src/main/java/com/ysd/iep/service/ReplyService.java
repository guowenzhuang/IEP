package com.ysd.iep.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;

@PermissionType("回复")
public interface ReplyService {
	/**
	 * 查询回复列表
	 * @param postId 所属帖子id
	 * @return
	 */
	public List<Reply> queryReplyByPostId(Integer postId);
	/**
	 * 更新浏览数
	 * @param replyId
	 * @return
	 */
	public Integer updateBrowse(Integer replyId);
	
	/**
	 *   点赞
	 * @param replyId
	 * @param userId
	 * @return
	 */
	public Integer replyLike(Integer replyId,String userId);
	
	/**
	 *   根据用户id查询该回复是否点过赞
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer userIsLike(String userId,Integer replyId);
	/**
	 * 取消点赞
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer deleteLike(String userId,Integer replyId);
	
	/**
	 *  回复帖子
	 * @param reply
	 * @return
	 */
	public Integer insertReply(String replyContent,Integer parentId,Integer postId,String userId);
	
	/**
	 *   根据postId和parentId查询replyId
	 * @param postId
	 * @param parentId
	 * @return
	 */
	public Integer queryReplyIdByPostIdAndParentId(Integer postId,Integer parentId);
	
	/**
	 *  用户是否举报
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer userIsReport(String userId,Integer replyId);
	
	/**
	 * 用户举报功能
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer userReport(String userId,Integer replyId,String reportReason);
	/**
	 *  通过回复id查询用户id
	 * @param replyId
	 * @return
	 */
	public String queryUserIdByReplyId(Integer replyId);
	
	/**
	 * 带条件分页查询回复
	 * (管理員方法)
	 * @param Reply
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Reply> queryAllPage(ReplyQuery replyQuery, Pageable pageable);
	
	/**
	 * 通过userId获取回复
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<Reply> queryReplyByUserId(String userId,Pageable pageable);
	
	/**
	 * 修改是否删除状态为1（软删除）
	 * @param replyId
	 * @return
	 */
	@PreAuthorize("hasAuthority('reply:upReplyIsDel')")
    @PermissionMethod("软删除操作")
	public Integer upReplyIsDel(Integer replyId);
	
	/**
	 * 修改是否删除状态为0（还原）
	 * @param replyId
	 * @return
	 */
	@PreAuthorize("hasAuthority('reply:upReplyIsDelO')")
    @PermissionMethod("还原操作")
	public Integer upReplyIsDelO(Integer replyId);
	
	/**
	 * 获取帖子详情集合
	 * @return
	 */
	public List<Reply> getPostList(List<Integer> postIds);
	/**
	 * 获取点赞数集合
	 * @param replyIds
	 * @return
	 */
	public List<Integer> getLikeNumList(List<Integer> replyIds);
	/**
	 * 获取举报数集合
	 * @param replyIds
	 * @return
	 */
	public List<Integer> getReportNumList(List<Integer> replyIds);
	
	/**
	 * 获取回复数集合
	 * @param postIds
	 * @return
	 */
	public List<BigInteger> getReplyNumList(List<Integer> postIds);
	/**
	 * 	删除回复
	 * @param replyId
	 * @return
	 */
	public int deleteReply(Integer replyId);

}
