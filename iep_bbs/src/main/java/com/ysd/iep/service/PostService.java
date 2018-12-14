package com.ysd.iep.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;


public interface PostService {
	/**
	 * 带条件分页查询帖子
	 * @param post
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Reply> queryAllPage(PostQuery postQuery, Integer page, Integer size);
	/**
	 * 获取帖子点赞数
	 * @param userId
	 * @param replyId
	 * @return
	 */	
	public Integer getLikeNum(Integer replyId);
	/**
	 * 更新帖子点赞数
	 * @param replyId
	 * @return
	 */
	public Integer updateLikeNum(Integer replyId,Integer likeNum);
	/**
	 * 根据postid查询帖子
	 * @param postId
	 * @return
	 */
	public Post queryPostByPostId(Integer postId);
	/**
	 * 发表帖子
	 * @param post
	 * @return
	 */
	public Reply insertPost(Reply reply); 
	/**
	 * 删除帖子(管理员操作)
	 * @return
	 */
	public Integer deletePost(String content,Integer replyId);

}
