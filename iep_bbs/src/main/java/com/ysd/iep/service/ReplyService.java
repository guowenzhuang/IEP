package com.ysd.iep.service;

import java.util.List;


import com.ysd.iep.entity.Reply;


public interface ReplyService {
	/**
	 * 查询回复列表
	 * @param postId 所属帖子id
	 * @return
	 */
	public List<Reply> queryReplyByPostId(Integer postId);

}
