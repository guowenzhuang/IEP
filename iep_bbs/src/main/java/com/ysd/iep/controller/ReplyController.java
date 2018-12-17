package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Reply;
import com.ysd.iep.service.PostService;
import com.ysd.iep.service.ReplyService;

@RestController
@RequestMapping(value = "reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private PostService postService;

	/**
	 * 查询帖子下的回复列表
	 * 
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "getReplyByPostId", method = RequestMethod.POST)
	public Object getReplyByPostId(Integer postId) {
		List<Reply> replylist = replyService.queryReplyByPostId(postId);
		return replylist;
	}

	/**
	 * 更新浏览数
	 * 
	 * @param replyId
	 * @return
	 */
	@RequestMapping(value = "updateBrowse")
	public Object updateBrowse(Integer replyId) {
		return replyService.updateBrowse(replyId);
	}

	/**
	 * 点赞
	 * 
	 * @param userId
	 * @param replyId
	 * @return
	 */
	@RequestMapping(value = "replyLike")
	public Object replyLike(Integer userId, Integer replyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n = replyService.replyLike(replyId, userId);
		if (n > 0) {
			map.put("success", true);
			map.put("message", "点赞成功");
			return map;
		} else {
			map.put("success", false);
			map.put("message", "点赞失败");
			return map;
		}
	}

	/**
	 * 回复
	 * 
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "insertReply")
	public Object insertReply(Reply reply) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("reply==>" + reply);
		Reply reply2 = replyService.insertReply(reply);
		if (reply2 != null) {
			map.put("success", true);
			map.put("message", "回复成功");
			return map;
		} else {
			map.put("success", false);
			map.put("message", "回复失败");
			return map;
		}
	}

}
