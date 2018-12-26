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

}
