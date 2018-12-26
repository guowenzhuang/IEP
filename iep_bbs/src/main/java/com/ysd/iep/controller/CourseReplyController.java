package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.CoursePost;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.service.CourseReplyService;

@RestController
@RequestMapping(value = "coursereply")
public class CourseReplyController {
	@Autowired
	private CourseReplyService replyService;
	
	@RequestMapping(value = "queryAllReply", method = RequestMethod.POST)
	public Object queryAllReply(String userId, Integer courseId, Integer page, Integer rows) {
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<CourseReply> replys = replyService.queryAllReply(userId, courseId, pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = replys.getTotalElements();
		List<CourseReply> list = replys.getContent();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

}
