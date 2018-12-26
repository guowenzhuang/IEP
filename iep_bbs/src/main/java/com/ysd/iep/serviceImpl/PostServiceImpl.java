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

		StringBuilder dataSql = new StringBuilder("SELECT * FROM posttb p JOIN replytb r ON p.post_id=r.post_id ");
		StringBuilder countSql = new StringBuilder(
				"SELECT COUNT(1) FROM posttb p JOIN replytb r ON p.post_id=r.post_id");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE r.reply_parentid = 0 ");
		if (StringUtils.isNotEmpty(postQuery.getPostTitle())) {
			whereSql.append(" AND p.post_title like '%" + postQuery.getPostTitle() + "%' ");
		}
		if (StringUtils.isNotEmpty(postQuery.getTypeName())) {
			whereSql.append("AND p.post_id IN (SELECT post_id FROM posttypetb pt WHERE type_id="
					+ "(SELECT type_id FROM typetb WHERE type_name='" + postQuery.getTypeName() + "'))");
		}
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY p.post_isstick=1 desc");
		if ("replyTime".equals(postQuery.getOrderBy())) {
			orderBySql.append(" , r.reply_time desc");
		}
		if ("replyLikenum".equals(postQuery.getOrderBy())) {
			orderBySql.append(" , r.reply_likenum desc");
		}
		if ("replyReportnum".equals(postQuery.getOrderBy())) {
			orderBySql.append(" , r.reply_reportnum desc");
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
	@Override
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
	public Integer publicPost(String title, String content, Integer parentId, String userId) {
		Post post = new Post();
		post.setPostTitle(title);
		post.setPostIsstick(false);
		System.out.println("post==>" + post);
		Post post2 = postRepository.save(post);
		int m = replyRepository.insertPortDetails(userId, post2.getPostId(), content, parentId);
		if (m > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Page<Post> queryPostByUserId(String userId, Pageable pageable ) {
		StringBuilder dataSql = new StringBuilder("SELECT * FROM posttb p JOIN replytb r ON p.post_id=r.post_id ");
		StringBuilder countSql = new StringBuilder(
				"SELECT COUNT(1) FROM posttb p JOIN replytb r ON p.post_id=r.post_id");
		// 拼接where条件
		StringBuilder whereSql = new StringBuilder(" WHERE r.user_id ='" + userId + "' AND r.reply_parentid = 0");
		// 拼接orderBy条件
		StringBuilder orderBySql = new StringBuilder("ORDER BY r.reply_time desc");
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

}
