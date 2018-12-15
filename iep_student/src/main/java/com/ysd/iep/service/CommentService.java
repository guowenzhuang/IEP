package com.ysd.iep.service;

import com.ysd.iep.entity.CommentDTO;
import org.springframework.data.domain.Page;

import com.ysd.iep.entity.StudentComment;

public interface CommentService {
	
	/**
	 * 分页排序查询
	 * @param page
	 * @param size
	 * @return
	 */
	Page<CommentDTO> queryAllPage(Integer page, Integer size, String orderBy);
	

}
