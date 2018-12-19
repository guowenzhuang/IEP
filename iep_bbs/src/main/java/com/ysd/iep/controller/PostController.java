package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.PostService;
import com.ysd.iep.tools.Result;



@RestController
@RequestMapping(value = "post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private AdminFeign adminFeign;

	/**
	 * 动态分页查询
	 * 
	 * @param postQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "getAllPost", method = RequestMethod.POST)
	public Object getAllPost(PostQuery postQuery, Integer page, Integer rows) {

		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Post> posts = postService.queryAllPage(postQuery, pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = posts.getTotalElements();
		List<Post> list = posts.getContent();
		for (Post post : list) {
			// 查询出帖子详情添加进帖子对象
			Reply postDetails = postService.getPostDetails(post.getPostId(), 0);
			BeanUtils.copyProperties(postDetails, post);
			// 从点赞记录表中查询每个帖子的点赞数添加到属性里
			int likeNum = postService.getLikeNum(post.getReplyId());
			post.setReplyLikenum(likeNum);
			System.out.println("replyid" + post.getReplyId() + "  " + likeNum);
			// 将点赞数更新到数据库的字段里
			postService.updateLikeNum(post.getReplyId(), likeNum);
			// 查询每个帖子举报数
			int reportNum = postService.getReportNum(post.getReplyId());
			post.setReplyReportnum(reportNum);
			postService.updateReportNum(post.getReplyId(), reportNum);
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	/**
	 * 发表帖子
	 */
	@RequestMapping(value = "insertPost")
	public Object insertPost(String title, String content, String userId) {
		int n = postService.publicPost(title, content, 0, userId);
		if (n > 0) {
			return new Result(true, "发表成功");
		} else {
			return new Result(false, "发表失败");
		}

	}

	/**
	 * 通过用户id获取用户信息
	 * @return
	 */
	@GetMapping("/getUserById")
	public Result getUserById() {
		return adminFeign.getUserById();
	}
}
