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
	public Object getReplyByPostId(Integer postId,String userId) {
		List<Reply> replylist = replyService.queryReplyByPostId(postId);
		//判断该回复回复的是帖子还是别人的回复
		for (Reply reply : replylist) {
			Integer replyId=replyService.queryReplyIdByPostIdAndParentId(postId,0);
			if(reply.getReplyParentid()!=replyId) {
				reply.setIsReply(true);
			}else {
				reply.setIsReply(false);
			}
			if(userId!=null&&!("".equals(userId))) {
				int n=replyService.userIsLike(userId, reply.getReplyId());
				if(n>0) {	//用户点过赞
					reply.setIsLike(true);
				}else {		//用户未点赞
					reply.setIsLike(false);
				}
				int m=replyService.userIsReport(userId, reply.getReplyId());
				if(m>0) {	
					reply.setIsReport(true);;		//用户已举报过该回复
				}else {
					reply.setIsReport(false);;	//用户未举报过
				}
			}
			
		}
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
	public Object replyLike(String userId, Integer replyId, Boolean isLike) {
		Map<String, Object> map = new HashMap<String, Object>();
		int m;
		if(isLike) {	//该用户点过赞，取消点赞
			m=replyService.deleteLike(userId, replyId);
			if(m>0) {
				map.put("success", true);
				map.put("message", "取消点赞");
			}else {
				map.put("success", false);
				map.put("message", "取消点赞失败");
			}
		}else {	 //该用户未点赞
			m = replyService.replyLike(replyId, userId);
			if(m>0) {
				map.put("success", true);
				map.put("message", "点赞成功");
			}else {
				map.put("success", false);
				map.put("message", "点赞失败");
			}	
		}
		return map;
	}

	/**
	 * 回复
	 * 
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "insertReply")
	public Object insertReply(String replyContent,Integer postId,String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer parentId=replyService.queryReplyIdByPostIdAndParentId(postId, 0);
		int n=replyService.insertReply(replyContent, parentId, postId, userId);
		if (n>0) {
			map.put("success", true);
			map.put("message", "回复成功");
		} else {
			map.put("success", false);
			map.put("message", "回复失败");
		}
		return map;
	}
	/**
	 *    举报
	 * @param userId
	 * @param replyId
	 * @param reportReason
	 * @return
	 */
	@RequestMapping(value = "userReport")
	public Object userReport(String userId,Integer replyId,String reportReason) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n=replyService.userReport(userId, replyId, reportReason);
		if (n>0) {
			map.put("success", true);
			map.put("message", "举报成功");
		} else {
			map.put("success", false);
			map.put("message", "举报失败");
		}
		return map;
	}

}
