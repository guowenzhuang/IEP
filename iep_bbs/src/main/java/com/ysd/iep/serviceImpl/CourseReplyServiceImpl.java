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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.CourseReplyRepository;
import com.ysd.iep.entity.CourseReply;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.service.CourseReplyService;

@Service
public class CourseReplyServiceImpl implements CourseReplyService {
	@Autowired
	private CourseReplyRepository replyRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<CourseReply> queryAllReply(String userId, Integer courseId, Pageable pageable) {
		StringBuilder dataSql = new StringBuilder("SELECT * FROM  coursereplytb");
		StringBuilder countSql = new StringBuilder("SELECT COUNT(1) FROM  coursereplytb");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE reply_parentid > 0 ");
		if (StringUtils.isNotEmpty(userId)) {
			whereSql.append("AND user_id='" + userId + "'");
		}
		if (courseId != null) {
			whereSql.append("AND course_id=" + courseId + " ");
		}
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY reply_time desc");

		// 组装sql语句
		dataSql.append(whereSql).append(orderBySql);
		countSql.append(whereSql);

		Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), CourseReply.class);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		// 设置分页
		dataQuery.setFirstResult((int) pageable.getOffset());
		dataQuery.setMaxResults(pageable.getPageSize());
		BigInteger count = (BigInteger) countQuery.getSingleResult();
		Long total = count.longValue();
		List<CourseReply> content2 = total > pageable.getOffset() ? dataQuery.getResultList()
				: Collections.<CourseReply>emptyList();
		return new PageImpl<>(content2, pageable, total);
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
	 * 回复帖子
	 */
	@Override
	public Integer insertReply(String replyContent, Integer parentId, Integer postId, String userId, Integer courseId) {
		return replyRepository.insertPortDetails(courseId, userId, postId, replyContent, parentId);
	}

	/**
	 * 根据postId和parentId查询replyId
	 */
	@Override
	public Integer queryReplyIdByPostIdAndParentId(Integer postId, Integer parentId) {
		return replyRepository.queryReplyIdByPostIdAndParentId(postId, parentId);
	}



	@Override
	public List<CourseReply> queryReplyByPostId(Integer postId) {
		return replyRepository.queryReplyByPostId(postId);
	}
	
	/**
	 * 通过回复id查询用户id
	 */
	@Override
	public String queryUserIdByReplyId(Integer replyId) {
		return replyRepository.queryUserIdByReplyId(replyId);
	}
	
	/**
	 * 查询该用户是否对该帖子点赞
	 */
	@Override
	public Integer userIsLike(String userId, Integer replyId) { 
		return replyRepository.userIsLike(userId, replyId);
	}
	
	/**
	 * 点赞
	 */
	@Override
	public Integer replyLike(Integer replyId, String userId) {
		return replyRepository.replyLike(replyId, userId);
	}
	
	@Override
	public Integer deleteLike(String userId, Integer replyId) {
		return replyRepository.deleteLike(userId, replyId);
	}
	
	@Override
	public Integer getCoursePostNum(Integer courseId) {
		return replyRepository.getCoursePostNum(courseId);
	}

}
