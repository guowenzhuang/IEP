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
import com.ysd.iep.service.CoursePostService;

@RestController
@RequestMapping(value = "coursepost")
public class CoursePostController {
	@Autowired
	private CoursePostService postService;

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
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	
	

}
