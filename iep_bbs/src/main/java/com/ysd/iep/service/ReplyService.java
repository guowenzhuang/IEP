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
	public Integer replyLike(Integer replyId,Integer userId);
	
	/**
	 *  回复帖子
	 * @param reply
	 * @return
	 */
	public Reply insertReply(Reply reply);

}
