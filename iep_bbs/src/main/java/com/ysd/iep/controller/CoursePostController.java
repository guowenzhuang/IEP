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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.CoursePost;
import com.ysd.iep.entity.CoursePostQuery;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.CoursePostService;
import com.ysd.iep.service.CourseReplyService;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value = "coursepost")
public class CoursePostController {
	@Autowired
	private CoursePostService postService;
	@Autowired
	private CourseReplyService replyService;
	@Autowired
	private AdminFeign adminFeign;

	/**
	 * 动态查询
	 * @GetMapping 查询
	 * @PutMapping 修改
	 * @PostMapping 添加
	 * @DeleteMapping 删除
	 * 
	 * @param postQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "getAllCoursePost")
	public Object getAllCoursePost(CoursePostQuery postQuery, Integer page, Integer rows) {

		Pageable pageable = new PageRequest(page - 1, rows);
		Page<CoursePost> posts = postService.queryAllCoursePost(postQuery, pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = posts.getTotalElements();
		List<CoursePost> list = posts.getContent();
		for (CoursePost coursePost : list) {
			CourseReply postDetails = postService.getPostDetails(coursePost.getPostId(), 0);
			BeanUtils.copyProperties(postDetails, coursePost);
			// 从点赞记录表中查询每个帖子的点赞数添加到属性里
			int likeNum = postService.getLikeNum(coursePost.getReplyId());
			coursePost.setReplyLikenum(likeNum);
			// 将点赞数更新到数据库的字段里
			postService.updateLikeNum(coursePost.getReplyId(), likeNum);			
			// 通过用户id获取用户信息
			Result user = adminFeign.getNameById(coursePost.getUserId());
			coursePost.setUserName(user.getMessage());
			//获取帖子的回复数并更新到数据表中
			Integer replynum=postService.getReplyNum(coursePost.getPostId());
			coursePost.setReplyNum(replynum);
			
			postService.updateReplyNum(replynum,coursePost.getPostId());
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	/**
	 * 根据帖子id获取帖子详情
	 * @return
	 */
	@RequestMapping(value="getPostDetailsByPostId")
	public Object getPostDetailsByPostId(Integer postId) {
		CoursePost post=postService.getPostByPostId(postId);
		CourseReply postDetails = postService.getPostDetails(postId, 0);
		BeanUtils.copyProperties(postDetails, post);
		Result user = adminFeign.getNameById(postDetails.getUserId());
		post.setUserName(user.getMessage());
		
		Integer replynum=postService.getReplyNum(postId);
		post.setReplyNum(replynum);
		return post;
	}

	/**
	 * 发表帖子
	 */
	@PostMapping(value = "insertPost")
	public Object insertPost(Integer courseId, String title, String content, String userId, Integer typeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n = postService.publicPost(courseId, title, content, 0, userId, typeId);
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
	 * 判断用户是否点赞帖子
	 * @return
	 */
	@RequestMapping(value = "userIsPost")
	public Object userIsPost(Integer replyId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean isLikePost;
		Integer n = replyService.userIsLike(userId, replyId);
		if (n > 0) {
			isLikePost = true;
		} else {
			isLikePost = false;
		}
		map.put("isLikePost", isLikePost);
		return map;
	}
	/**
	 * 获取热门讨论
	 * @param courseIds
	 * @return
	 */
	@GetMapping(value = "getHotPost")
	public Object getHotPost(@RequestParam("courseIds")List<Integer> courseIds) {
		List<CoursePost> postList= postService.getHotPost(courseIds);
		for (CoursePost coursePost : postList) {
			CourseReply postDetails = postService.getPostDetails(coursePost.getPostId(), 0);
			BeanUtils.copyProperties(postDetails, coursePost);
		}
		return postList;
	}

}
