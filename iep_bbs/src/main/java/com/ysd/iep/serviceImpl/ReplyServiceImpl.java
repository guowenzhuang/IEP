package com.ysd.iep.serviceImpl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.ReplyRepository;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.ReplyQuery;
import com.ysd.iep.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 动态分页查询（后台管理）
	 */
	public Page<Reply> queryAllPage(ReplyQuery replyQuery, Pageable pageable) {
		StringBuilder dataSql = new StringBuilder("SELECT * FROM  replytb");
		StringBuilder countSql = new StringBuilder("SELECT COUNT(1) FROM  replytb");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE reply_parentid > 0 ");
		if (StringUtils.isNotEmpty(replyQuery.getUserName())) {
			whereSql.append(" AND user_name like '%" + replyQuery.getUserName() + "%'");
		}
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY reply_time desc");
		if ("replyLikenum".equals(replyQuery.getOrderBy())) {
			orderBySql.append(" , reply_likenum desc");
		}
		if ("replyReportnum".equals(replyQuery.getOrderBy())) {
			orderBySql.append(" , reply_reportnum desc");
		}
		// 组装sql语句
		dataSql.append(whereSql).append(orderBySql);
		countSql.append(whereSql);

		Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), Reply.class);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		// 设置分页
		dataQuery.setFirstResult((int) pageable.getOffset());
		dataQuery.setMaxResults(pageable.getPageSize());
		BigInteger count = (BigInteger) countQuery.getSingleResult();
		Long total = count.longValue();
		List<Reply> content2 = total > pageable.getOffset() ? dataQuery.getResultList()
				: Collections.<Reply>emptyList();
		return new PageImpl<>(content2, pageable, total);

	}

	/**
	 * 查询回复列表
	 * 
	 * @param postId 所属帖子id
	 * @return
	 */
	@Override
	public List<Reply> queryReplyByPostId(Integer postId) {
		return replyRepository.queryReplyByPostId(postId);
	}

	/**
	 * 更新浏览数
	 * 
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
	 * 查询该用户是否对该帖子点赞
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
	public Integer insertReply(String replyContent, Integer parentId, Integer postId, String userId) {
		return replyRepository.insertReply(replyContent, parentId, postId, userId);
	}

	/**
	 * 根据postId和parentId查询replyId
	 */
	@Override
	public Integer queryReplyIdByPostIdAndParentId(Integer postId, Integer parentId) {
		return replyRepository.queryReplyIdByPostIdAndParentId(postId, parentId);
	}

	/**
	 * 用户是否举报
	 */
	@Override
	public Integer userIsReport(String userId, Integer replyId) {
		return replyRepository.userIsReport(userId, replyId);
	}

	/**
	 * 用户举报功能
	 */
	@Override
	public Integer userReport(String userId, Integer replyId, String reportReason) {
		return replyRepository.userReport(userId, replyId, reportReason);
	}

	/**
	 * 通过回复id查询用户id
	 */
	@Override
	public String queryUserIdByReplyId(Integer replyId) {
		return replyRepository.queryUserIdByReplyId(replyId);
	}

	/**
	 * 通过userId获取回复
	 */
	@Override
	public Page<Reply> queryReplyByUserId(String userId, Pageable pageable) {
		StringBuilder dataSql = new StringBuilder("SELECT * FROM  replytb");
		StringBuilder countSql = new StringBuilder("SELECT COUNT(1) FROM  replytb");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE reply_parentid > 0 AND user_id='" + userId + "'");
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY reply_time desc");
		// 组装sql语句
		dataSql.append(whereSql).append(orderBySql);
		countSql.append(whereSql);

		Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), Reply.class);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		// 设置分页
		dataQuery.setFirstResult((int) pageable.getOffset());
		dataQuery.setMaxResults(pageable.getPageSize());
		BigInteger count = (BigInteger) countQuery.getSingleResult();
		Long total = count.longValue();
		List<Reply> content2 = total > pageable.getOffset() ? dataQuery.getResultList()
				: Collections.<Reply>emptyList();
		return new PageImpl<>(content2, pageable, total);
	}
	
	
	@Override
	public Integer upReplyIsDel(Integer replyId) {
		// TODO Auto-generated method stub
		return replyRepository.upReplyIsDel(replyId);
	}

	@Override
	public Integer upReplyIsDelO(Integer replyId) {
		// TODO Auto-generated method stub
		return replyRepository.upReplyIsDelO(replyId);
	}

	@Override
	public List<Reply> getPostList(List<Integer> postIds) {
		// TODO Auto-generated method stub
		return replyRepository.getPostList(postIds);
	}

	@Override
	public List<Integer> getLikeNumList(List<Integer> replyIds) {
		// TODO Auto-generated method stub
		return replyRepository.getLikeNumList(replyIds);
	}

	@Override
	public List<Integer> getReportNumList(List<Integer> replyIds) {
		// TODO Auto-generated method stub
		return replyRepository.getReportNumList(replyIds);
	}

	@Override
	public List<Integer> getReplyNumList(List<Integer> postIds) {
		// TODO Auto-generated method stub
		return replyRepository.getReplyNumList(postIds);
	}


}
