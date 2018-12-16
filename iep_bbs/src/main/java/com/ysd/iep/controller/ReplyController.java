package com.ysd.iep.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Reply;
import com.ysd.iep.service.PostService;
import com.ysd.iep.service.ReplyService;

@RestController
@RequestMapping(value="reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="getReplyByPostId")
	public Object getReplyByPostId(Integer postId) {
		List<Reply> replylist = replyService.queryReplyByPostId(postId);
		return replylist;
	}


}
