package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostPage;
import com.ysd.iep.service.PostService;

@RestController
@RequestMapping(value="post")
public class PostController {
	
	@Autowired
	private PostService postService;
	/**
	 * 动态分页查询
	 * @param postQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="getAllPost")
	public Object getAllPost(PostPage postPage,Integer page,Integer rows) {
		postPage.setReplyParentid(0); 	//回复的parentid为0的是帖子,此处是查询所有的帖子对象
		Page<PostPage> posts = postService.queryAllPage(postPage, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = posts.getTotalElements();
		List<PostPage> list = posts.getContent();
		for (PostPage post : list) {	//循环从点赞记录表中查询每个帖子的点赞数并添加到属性里
			int likeNum=postService.getLikeNum(post.getUserId(), post.getReplyId());
			post.setLikeNum(likeNum);
		}
		System.out.println("list==>" + list);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 
	 * @param userId
	 * @param replyId
	 * @return
	 */
	public Object getLikeNum(Integer userId,Integer replyId) {
		int likeNum=postService.getLikeNum(userId, replyId);
		return likeNum;
		
	}

}
