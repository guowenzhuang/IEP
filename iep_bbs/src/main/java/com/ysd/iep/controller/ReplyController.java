package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;
import com.ysd.iep.service.PostService;
import com.ysd.iep.service.ReplyService;

@RestController
@RequestMapping(value="reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="queryAllReplyPage")
	public Object queryAllReplyPage(ReplyQuery replyQuery, Integer page, Integer rows) {
		
		Page<Reply> reply=replyService.queryAllReplyPage(replyQuery, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = reply.getTotalElements();
		List<Reply> list = reply.getContent();
		for(Reply reply2 : list) {
			int likeNum=postService.getLikeNum(reply2.getReplyId());
			reply2.setReplyLikenum(likeNum);
		}
		System.out.println("replyList==>"+list);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

}
