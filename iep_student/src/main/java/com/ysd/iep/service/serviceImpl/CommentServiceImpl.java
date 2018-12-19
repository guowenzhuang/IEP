package com.ysd.iep.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ysd.iep.entity.CommentDTO;
import com.ysd.iep.entity.StudentComment;
import com.ysd.iep.repository.CommentRepository;
import com.ysd.iep.service.CommentService;


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
    
	//根据课程id查询该课程的评价
	@Override
	public Page<StudentComment> queryCommentByCid(Integer cid,Integer page,Integer size) {

	    Sort sort=new Sort(Sort.Direction.DESC,"praise");
		Pageable pageable=PageRequest.of(page-1,size,	sort);
		return commentRepository.findByCid(cid,pageable);
	}

	//针对某课程发表评价
	@Override
	public Result addComment(StudentComment comment) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try {
			Date time=df.parse(df.format(new Date()));//发表评价的时间
			comment.setMtime(time);
			//comment.setPraise(comment.getPraise()+1);
			commentRepository.save(comment);
			System.out.println("commentService"+comment);
			return new Result(true,"发表成功");
		} catch (ParseException e) {
			//e.printStackTrace();
			return new Result(false,"发表失败");
		}
	}
	
	
	
	

}
