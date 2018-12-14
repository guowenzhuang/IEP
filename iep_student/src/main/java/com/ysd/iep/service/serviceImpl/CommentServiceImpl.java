package com.ysd.iep.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ysd.iep.entity.StudentComment;
import com.ysd.iep.repository.CommentRepository;
import com.ysd.iep.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Page<StudentComment> queryAllPage(Integer page, Integer size) {
		
		Sort sort = new Sort(Sort.Direction.ASC, "cid");
		Pageable pageable = new PageRequest(page, size, sort);
		return commentRepository.findAll(pageable);
	}

}
