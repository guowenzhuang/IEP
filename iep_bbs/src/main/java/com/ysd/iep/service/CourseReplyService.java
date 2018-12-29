package com.ysd.iep.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Reply;

public interface CourseReplyService {
	
	public Page<CourseReply> queryAllReply(String userId,Integer courseId,Pageable pageable); 
	
	/**
	 * 更新浏览数
	 * @param replyId
	 * @return
	 */
	public Integer updateBrowse(Integer replyId);
	
	/**
	 *  回复帖子
	 * @return
	 */
	public Integer insertReply(String replyContent,Integer parentId,Integer postId,String userId,Integer courseId);
	
	/**
	 *   根据postId和parentId查询replyId
	 * @param postId
	 * @param parentId
	 * @return
	 */
	public Integer queryReplyIdByPostIdAndParentId(Integer postId,Integer parentId);
	
	/**
	 * 查询回复列表
	 * @param postId
	 * @return
	 */
	public List<CourseReply> queryReplyByPostId(Integer postId);
	
	/**
	 *  通过回复id查询用户id
	 * @param replyId
	 * @return
	 */
	public String queryUserIdByReplyId(Integer replyId);
	
	/**
	 *   根据用户id查询该回复是否点过赞
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer userIsLike(String userId,Integer replyId);
	
	/**
	 *   点赞
	 * @param replyId
	 * @param userId
	 * @return
	 */
	public Integer replyLike(Integer replyId,String userId);
	
	/**
	 * 取消点赞
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Integer deleteLike(String userId,Integer replyId);

}
