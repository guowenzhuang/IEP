package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.CoursePost;
import com.ysd.iep.entity.CoursePostQuery;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.CoursePostService;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value = "coursepost")
public class CoursePostController {
	@Autowired
	private CoursePostService postService;
	@Autowired
	private AdminFeign adminFeign;

	/**
	 * 动态查询
	 * 
	 * @param postQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "getAllCoursePost", method = RequestMethod.POST)
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
			// 通过用户id获取用户信息
			Result user = adminFeign.getNameById(coursePost.getUserId());
			coursePost.setUserName(user.getMessage());
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	/**
	 * 发表帖子
	 */
	@RequestMapping(value = "insertPost")
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

}
