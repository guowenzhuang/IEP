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

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.PostService;
import com.ysd.iep.service.ReplyService;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value = "reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private PostService postService;
	@Autowired
	private AdminFeign adminFeign;

	/**
	 * 查询帖子下的回复列表
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "getReplyByPostId", method = RequestMethod.POST)
	public Object getReplyByPostId(Integer postId,String userId) {
		List<Reply> replylist = replyService.queryReplyByPostId(postId);
		//判断该回复回复的是帖子还是别人的回复
		for (Reply reply : replylist) {
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
	public Object insertReply(String replyContent,Integer postId,String userId,Integer pId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer parentId;
		if(pId==0) {
			parentId=replyService.queryReplyIdByPostIdAndParentId(postId, 0);
		}else {
			parentId=pId;
		}
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
	
	
	/**
	 * 动态分页查询（后台管理）
	 * @param ReplyQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="getAllReply",method=RequestMethod.POST)
	public Object getAllReply(ReplyQuery replyQuery,Integer page,Integer rows) {
		
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Reply> replys = replyService.queryAllPage(replyQuery, pageable);
		System.out.println("replys==>"+replys);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = replys.getTotalElements();
		List<Reply> list = replys.getContent();
		for (Reply reply : list) {
			//从点赞记录表中查询每个帖子的点赞数添加到属性里
			int likeNum=postService.getLikeNum(reply.getReplyId());			
			reply.setReplyLikenum(likeNum);
			System.out.println("replyid"+reply.getReplyId()+"  "+likeNum);
			//将点赞数更新到数据库的字段里
			postService.updateLikeNum(reply.getReplyId(), likeNum);
			//查询每个帖子举报数
			int reportNum=postService.getReportNum(reply.getReplyId());
			reply.setReplyReportnum(reportNum);
			postService.updateReportNum(reply.getReplyId(), reportNum);
			
			reply.setReplyUsername(adminFeign.getNameById(reply.getUserId()).getMessage());
		}
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 查询帖子下的回复列表
	 * （后台管理）
	 * @param postId
	 * @return
	 */
	@RequestMapping(value = "getReplyList", method = RequestMethod.POST)
	public Object getReplyList(Integer postId) {
		 Map<String, Object> map = new HashMap<String, Object>();
		List<Reply> replylist = replyService.queryReplyByPostId(postId);
		map.put("rows", replylist);
		return map;
	}
	@RequestMapping(value = "queryReplyByUserId")
	public Object queryReplyByUserId(String userId,Integer page,Integer rows) {
		Pageable pageable = new PageRequest(page - 1, rows);
		Page<Reply> replys = replyService.queryReplyByUserId(userId, pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = replys.getTotalElements();
		List<Reply> list = replys.getContent();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}


}
