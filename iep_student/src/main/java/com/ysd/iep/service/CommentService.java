package com.ysd.iep.service;

import com.ysd.iep.util.Result;
import org.springframework.data.domain.Page;

import com.ysd.iep.entity.CommentDTO;
import com.ysd.iep.entity.StudentComment;

/**
 * 课程评价
 * @author ASUS
 *
 */
public interface CommentService {
	
	/**
	 * 分页排序查询
	 * @param page
	 * @param size
	 * @return
	 */
	Page<CommentDTO> queryAllPage(Integer page, Integer size, String orderBy);

	
	/**
	 * 根据课程id查询当前课程的评价
	 */
	public Page<StudentComment> queryCommentByCid(Integer cid,Integer page,Integer size);

	/**
	 * 根据学生id查询当前课程的评价
	 */
	public Page<StudentComment> queryCommentBySid(String sid,Integer page,Integer size);

	/**
	 * 学生发表评价
	 */
	public Result addComment(StudentComment comment);

	/**
	 * 修改点赞记录数
	 * @param mid
	 * @param praise
	 * @return
	 */
	public int updatePraise(Integer mid, Integer praise);
	
	

}
