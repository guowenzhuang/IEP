package com.ysd.iep.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.ReplyRepository;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;
import com.ysd.iep.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyRepository replyRepository;
	/**
	 * 查询回复列表
	 * @param postId 所属帖子id
	 * @return
	 */
	@Override
	public List<Reply> queryReplyByPostId(Integer postId) {
		return replyRepository.queryReplyByPostId(postId);
	}
	/**
	 * 更新浏览数
	 * @param replyId
	 * @return
	 */
	@Override
	public Integer updateBrowse(Integer replyId) {
		return replyRepository.updateBrowse(replyId);
	}
	/**
	 * 点赞
	 */
	@Override
	public Integer replyLike(Integer replyId, String userId) {
		return replyRepository.replyLike(replyId, userId);
	}
	/**
	 *  查询该用户是否对该帖子点赞
	 */
	@Override
	public Integer userIsLike(String userId, Integer replyId) {
		return replyRepository.userIsLike(userId, replyId);
	}
	@Override
	public Integer deleteLike(String userId, Integer replyId) {
		return replyRepository.deleteLike(userId, replyId);
	}
	
	/**
	 * 回复帖子
	 */
	@Override
	public Integer insertReply(String replyContent,Integer parentId,Integer postId,String userId) {
		return replyRepository.insertReply(replyContent, parentId, postId, userId);
	}
	
	/**
	 *   根据postId和parentId查询replyId
	 */
	@Override
	public Integer queryReplyIdByPostIdAndParentId(Integer postId,Integer parentId) {
		return replyRepository.queryReplyIdByPostIdAndParentId(postId, parentId);
	}
	/**
	 *  用户是否举报
	 */
	@Override
	public Integer userIsReport(String userId, Integer replyId) {
		return replyRepository.userIsReport(userId, replyId);
	}
	
	/**
	 * 用户举报功能
	 */
	@Override
	public Integer userReport(String userId,Integer replyId,String reportReason) {
		return replyRepository.userReport(userId, replyId, reportReason);
	}
	
}
