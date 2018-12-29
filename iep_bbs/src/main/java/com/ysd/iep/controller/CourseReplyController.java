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
import com.ysd.iep.entity.Reply;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.CourseReplyService;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value = "coursereply")
public class CourseReplyController {
	@Autowired
	private CourseReplyService replyService;	
	@Autowired
	private AdminFeign adminFeign;

	/**
	 * 查询帖子下的回复列表
	 * @param postId
	 * @param userId 发表回复人id
	 * @param loginUserId  登录用户id
	 * @return
	 */
	@RequestMapping(value = "getReplyByPostId", method = RequestMethod.POST)
	public Object getReplyByPostId(Integer postId,String loginUserId) {
		List<CourseReply> replylist = replyService.queryReplyByPostId(postId);
		//判断该回复回复的是帖子还是别人的回复
		for (CourseReply reply : replylist) {
			Integer postReplyId=replyService.queryReplyIdByPostIdAndParentId(postId,0);
			if(reply.getReplyParentid()!=postReplyId) {
				reply.setIsReply(true);
				reply.setReplyUsername(adminFeign.getNameById(reply.getUserId()).getMessage());
				Result byUserName=adminFeign.getNameById(replyService.queryUserIdByReplyId(reply.getReplyParentid()));
				reply.setByUsername(byUserName.getMessage());
			}else {
				reply.setIsReply(false);
				reply.setReplyUsername(adminFeign.getNameById(reply.getUserId()).getMessage());				
			}
			if(loginUserId!=null&&!("".equals(loginUserId))) {
				//查询用户是否对该回复点赞
				int n=replyService.userIsLike(loginUserId, reply.getReplyId());
				if(n>0) {	//用户点过赞
					reply.setIsLike(true);
				}else {		//用户未点赞
					reply.setIsLike(false);
				}
			}
			
		}
		return replylist;
	}
	/**
	 * 通过用户id查询回复
	 * @param userId
	 * @param courseId
	 * @param page
	 * @param rows
	 * @return
	 */
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
	 * 回复
	 * @param reply
	 * @return
	 */
	@RequestMapping(value = "insertReply")
	public Object insertReply(String replyContent, Integer postId, String userId, Integer pId, Integer courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer parentId;
		if (pId == 0) {
			parentId = replyService.queryReplyIdByPostIdAndParentId(postId, 0);
		} else {
			parentId = pId;
		}
		int n = replyService.insertReply(replyContent, parentId, postId, userId, courseId);
		if (n > 0) {
			map.put("success", true);
			map.put("message", "回复成功");
		} else {
			map.put("success", false);
			map.put("message", "回复失败");
		}
		return map;
	}
	
	/**
	 * 点赞 
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

}
