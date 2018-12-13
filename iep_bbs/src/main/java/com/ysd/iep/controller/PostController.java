package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.service.PostService;
import com.ysd.iep.tools.BeanConverterUtil;
import com.ysd.iep.tools.Result;

@RestController
@RequestMapping(value="post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	/**
	 * 动态分页查询
	 * @param postQuery
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="getAllPost")
	public Object getAllPost(PostQuery postQuery,Integer page,Integer rows) {
		
		Page<Reply> posts = postService.queryAllPage(postQuery, page, rows);
		Map<String, Object> map = new HashMap<String, Object>();
		long total = posts.getTotalElements();
		List<Reply> list = posts.getContent();
		for (Reply reply : list) {	//循环从点赞记录表中查询每个帖子的点赞数并添加到属性里
			int likeNum=postService.getLikeNum(reply.getUserId(), reply.getReplyId());
			reply.setReplyLikenum(likeNum);
			Post post2=reply.getPost();
			BeanUtils.copyProperties(post2,reply);
		}
		System.out.println("list==>" + list);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	/**
	 * 发表帖子
	 */
	@RequestMapping(value="insertPost")
	public Object insertPost(Reply reply) {
		Reply reply2=postService.insertPost(reply);
		if(reply2!=null) {
			return new Result(true,"发表成功");
		}else {
			return new Result(false,"发表失败");
		}
		
	}

}
