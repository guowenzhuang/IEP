package com.ysd.iep.service;

import org.springframework.data.domain.Page;

import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;

public interface ReplyService {
	
	public Page<Reply> queryAllReplyPage(ReplyQuery replyQuery,Integer page,Integer size);

}
