package com.ysd.iep.serviceImpl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.PostRepository;
import com.ysd.iep.dao.ReplyRepository;
import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Post> queryAllPage(PostQuery postQuery, Pageable pageable) {

		StringBuilder dataSql = new StringBuilder(
				"SELECT * FROM posttypetb pt JOIN posttb p " + "ON pt.post_id=p.post_id JOIN typetb t "
						+ "ON pt.type_id=t.type_id JOIN replytb r " + "ON p.post_id=r.post_id");
		StringBuilder countSql = new StringBuilder(
				"SELECT COUNT(1) FROM posttypetb pt JOIN posttb p " + "ON pt.post_id=p.post_id JOIN typetb t "
						+ "ON pt.type_id=t.type_id JOIN replytb r " + "ON p.post_id=r.post_id");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE 1 = 1 AND r.reply_parentid = 0 ");
		if (StringUtils.isNotEmpty(postQuery.getPostTitle())) {
			whereSql.append(" AND p.post_title like '%" + postQuery.getPostTitle() + "%' ");
		}
		if (StringUtils.isNotEmpty(postQuery.getTypeName())) {
			whereSql.append(" AND t.type_name like  '%" + postQuery.getTypeName() + "%' ");
		}
		if (StringUtils.isNotEmpty(postQuery.getUserName())) {
			whereSql.append(" AND u.user_name like '%" + postQuery.getUserName() + "%'");
		}
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY p.post_isstick=1");
		if ("replyTime".equals(postQuery.getOrderBy())) {
			orderBySql.append(" AND r.reply_time desc");
		}
		if ("replyLikenum".equals(postQuery.getOrderBy())) {
			orderBySql.append(" AND r.reply_likenum desc");
		}
		if ("replyReportnum".equals(postQuery.getOrderBy())) {
			orderBySql.append(" AND r.reply_reportnum desc");
		}
		// 组装sql语句
		dataSql.append(whereSql).append(orderBySql);
		countSql.append(whereSql);

		Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), Post.class);
		Query countQuery = entityManager.createNativeQuery(countSql.toString());

		// 设置分页
		dataQuery.setFirstResult((int) pageable.getOffset());
		dataQuery.setMaxResults(pageable.getPageSize());
		BigInteger count = (BigInteger) countQuery.getSingleResult();
		Long total = count.longValue();
		List<Post> content2 = total > pageable.getOffset() ? dataQuery.getResultList() : Collections.<Post>emptyList();
		return new PageImpl<>(content2, pageable, total);

	}

	/**
	 * 获取帖子详情
	 */
	public Reply getPostDetails(Integer postId, Integer parentId) {
		return replyRepository.getPostDetails(postId, parentId);
	}

	/**
	 * 根据回复id获取点赞数
	 */
	@Override
	public Integer getLikeNum(Integer replyId) {
		return replyRepository.getLikeNum(replyId);
	}

	/**
	 * 根据回复id更新点赞数
	 */
	@Override
	public Integer updateLikeNum(Integer replyId, Integer likeNum) {
		return replyRepository.updateLikeNum(replyId, likeNum);
	}
	/**
	 * 获取举报数
	 */
	@Override
	public Integer getReportNum(Integer replyId) {
		return replyRepository.getReportNum(replyId);
	}
	/**
	 * 更新举报数
	 */
	@Override
	public Integer updateReportNum(Integer replyId, Integer reportNum) {
		return replyRepository.updateReportNum(replyId, reportNum);
	}

	/**
	 * 根据帖子id查询帖子
	 */
	@Override
	public Post queryPostByPostId(Integer postId) {
		return postRepository.queryPostByPostId(postId);
	}

	/**
	 * 发表帖子
	 */
	@Override
	public Integer publicPost(String title, String content, Integer parentId, Integer postId, String userId) {
		int n = postRepository.insertPort(title);
		int m = replyRepository.insertPortDetails(userId, postId, content, parentId);
		if (n > 0 & m > 0) {
			return 1;
		}else {
			return 0;
		}
	}

}
