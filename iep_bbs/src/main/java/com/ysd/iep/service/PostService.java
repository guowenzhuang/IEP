package com.ysd.iep.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostPage;


public interface PostService {
	/**
	 * 带条件分页查询帖子
	 * @param post
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<PostPage> queryAllPage(PostPage postPage,Integer page,Integer size);
	/**
	 * 获取帖子点赞数
	 * @param userId
	 * @param replyId
	 * @return
	 */	
	public Integer getLikeNum(Integer userId,Integer replyId);
	/**
	 * 更新帖子点赞数
	 * @param replyId
	 * @return
	 */
	public Integer updateLikeNum(Integer replyId,Integer likeNum);

}
