package com.ysd.iep.service;

import java.util.List;


import com.ysd.iep.entity.Reply;


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
	
	

}
