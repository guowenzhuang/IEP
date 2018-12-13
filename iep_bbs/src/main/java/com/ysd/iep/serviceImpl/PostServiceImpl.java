package com.ysd.iep.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.LikeRepository;
import com.ysd.iep.dao.PostRepository;
import com.ysd.iep.dao.ReplyRepository;
import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.Typetb;
import com.ysd.iep.service.PostService;

import net.minidev.json.writer.BeansMapper.Bean;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public Page<Reply> queryAllPage(PostQuery postQuery, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "replyTime");
		Pageable pageable = new PageRequest(page - 1, size,sort);
		System.out.println("pageable=>"+this.getWhereClause(postQuery));
		return replyRepository.findAll(this.getWhereClause(postQuery), pageable);
	}

	private Specification<Reply> getWhereClause(final PostQuery postQuery) {
		//BeanUtils.copyProperties();
		return new Specification<Reply>() {
			@Override
			public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> exList = predicate.getExpressions();
				exList.add(cb.equal(root.<Integer>get("replyParentid"), 0));	//回复的parentid为0的是帖子,此处是查询所有的帖子对象

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
	public Reply insertPost(Reply reply) {
		Post post1=new Post();
		post1.setPostTitle(reply.getPostTitle());
		Post post2=postRepository.save(post1);
		reply.setPostId(post2.getPostId());
		Reply reply2=replyRepository.save(reply);
		return reply2;
		
	}

	/**
	 * 删除帖子
	 */
	@Override
	public Integer deletePost(Integer postId) {
		//查询该帖子是否有回复
		//List<Reply> reply=replyRepository.
		return null;
	}

}
