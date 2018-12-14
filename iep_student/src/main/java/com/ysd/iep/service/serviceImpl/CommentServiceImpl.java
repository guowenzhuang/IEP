package com.ysd.iep.service.serviceImpl;

import com.ysd.iep.entity.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ysd.iep.entity.StudentComment;
import com.ysd.iep.repository.CommentRepository;
import com.ysd.iep.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Page<CommentDTO> queryAllPage(Integer page, Integer size,String orderBy) {
		Sort sort = null;
		if(orderBy.equalsIgnoreCase("desc")){
			sort=new Sort(Sort.Direction.DESC,"cid");
		}else{
			sort=new Sort(Sort.Direction.ASC,"cid");
		}
		Pageable pageable=PageRequest.of(page-1,size,sort);
		return commentRepository.queryCommentPagingOrder(pageable);
	}

}
