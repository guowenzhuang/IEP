package com.ysd.iep.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.LikeRepository;
import com.ysd.iep.dao.PostRepository;
import com.ysd.iep.dao.PostpageRepository;
import com.ysd.iep.dao.ReplyRepository;
import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostPage;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.Typetb;
import com.ysd.iep.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private PostpageRepository postpageRepository;
	
	@Override
	public Page<PostPage> queryAllPage(PostPage postPage, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "publicTime");
		Pageable pageable = new PageRequest(page - 1, size,sort);
		System.out.println("pageable=>"+this.getWhereClause(postPage));
		//return postpageRepository.findAll(pageable);
		return postpageRepository.findAll(this.getWhereClause(postPage), pageable);
	}

	private Specification<PostPage> getWhereClause(final PostPage postPage) {
		return new Specification<PostPage>() {
			@Override
			public Predicate toPredicate(Root<PostPage> root, CriteriaQuery<?> queryy, CriteriaBuilder cb) {
				Join<Reply, Post> join = root.join("post", JoinType.INNER);
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> exList = predicate.getExpressions();
				exList.add(cb.equal(join.<Integer>get("replyParentid"), postPage.getReplyParentid()));

				return predicate;
			}

		};
	}
	
	/**
	 * 根据用户id和回复id获取点赞数
	 */
	@Override
	public Integer getLikeNum(Integer userId, Integer replyId) {
		// TODO Auto-generated method stub
		return likeRepository.getLikeNum(userId, replyId);
	}
	/**
	 * 根据回复id更新点赞数
	 */
	@Override
	public Integer updateLikeNum(Integer replyId,Integer likeNum) {
		// TODO Auto-generated method stub
		return replyRepository.updateLikeNum(replyId,likeNum);
	}

}
