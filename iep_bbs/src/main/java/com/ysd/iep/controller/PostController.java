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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.CoursePost;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.PostService;
import com.ysd.iep.service.ReplyService;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value = "post")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private ReplyService replyService;
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
			// 将点赞数更新到数据库的字段里
			postService.updateLikeNum(post.getReplyId(), likeNum);
			// 查询每个帖子举报数
			int reportNum = postService.getReportNum(post.getReplyId());
			post.setReplyReportnum(reportNum);
			postService.updateReportNum(post.getReplyId(), reportNum);
			// 通过用户id获取用户信息
			Result user = adminFeign.getNameById(post.getUserId());
			post.setUserName(user.getMessage());
			
			Integer replynum=postService.getReplyNum(post.getPostId());
			post.setReplyNum(replynum);
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
		Map<String, Object> map = new HashMap<String, Object>();
		int n = postService.publicPost(title, content, 0, userId);
		if (n > 0) {
			map.put("success", true);
			map.put("message", "发表成功");
		} else {
			map.put("success", false);
			map.put("message", "发表失败");
		}
		return map;

	}

	/**
	 * 判断用户是否点赞和举报帖子
	 * @return
	 */
	@RequestMapping(value = "userIsPost")
	public Object userIsPost(Integer replyId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean isLikePost, isReportPost;
		int n = replyService.userIsLike(userId, replyId);
		int m = replyService.userIsReport(userId, replyId);
		if (n > 0) {
			isLikePost = true;
		} else {
			isLikePost = false;
		}
		if (m > 0) {
			isReportPost = true;
		} else {
			isReportPost = false;
		}
		map.put("isLikePost", isLikePost);
		map.put("isReportPost", isReportPost);
		return map;
	}

	/**
	 * 通过用户id获取用户信息
	 * 
	 * @return
	 */
	@GetMapping("/getNameById")
	public Result getUserById(@RequestParam("id") String id) {
		return adminFeign.getNameById(id);
	}

	/**
	 * 通过用户id分页查询帖子
	 */
	@RequestMapping(value = "queryPostByUserId")
	public Object queryPostByUserId(String userId, Integer page, Integer rows) {
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Post> posts = postService.queryPostByUserId(userId, pageable);
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
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 置顶帖子 （管理员功能）
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="stickPost")
	public Object stickPost(Integer postId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n=postService.stickPost(postId);
		if (n > 0) {
			map.put("success", true);
			map.put("message", "置顶成功");
		} else {
			map.put("success", false);
			map.put("message", "置顶失败");
		}
		return map;
	}
	
	/**
	 * 取消置顶 （管理员功能）
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="cancelStick")
	public Object cancelStick(Integer postId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n=postService.cancelStick(postId);
		if (n > 0) {
			map.put("success", true);
			map.put("message", "置顶成功");
		} else {
			map.put("success", false);
			map.put("message", "置顶失败");
		}
		return map;
	}
	/**
	 * 根据帖子id获取帖子详情
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="getPostDetailsByPostId")
	public Object getPostDetailsByPostId(Integer postId) {
		
		Post post=postService.getPostByPostId(postId);
		Reply postDetails = postService.getPostDetails(postId, 0);
		BeanUtils.copyProperties(postDetails, post);
		Result user = adminFeign.getNameById(postDetails.getUserId());
		post.setUserName(user.getMessage());
		
		Integer replynum=postService.getReplyNum(postId);
		post.setReplyNum(replynum);
		return post;
	}
	
}
