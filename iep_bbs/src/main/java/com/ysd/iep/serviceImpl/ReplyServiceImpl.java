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

	@Override
	public Page<Reply> queryAllReplyPage(ReplyQuery replyQuery, Integer page, Integer size) {
		Sort sort = null;
		if ("replyLikenum".equals(replyQuery.getOrderBy())) {
			sort = new Sort(Sort.Direction.DESC, "replyLikenum");
		} else if ("replyReportNum".equals(replyQuery.getOrderBy())) {
			sort = new Sort(Sort.Direction.DESC, "replyReportnum");
		} else {
			sort = new Sort(Sort.Direction.DESC, "replyTime");// 排序
		}
		Pageable pageable = new PageRequest(page - 1, size,sort);
		System.out.println("pageable=>"+this.getWhereClause(replyQuery));
		return replyRepository.findAll(this.getWhereClause(replyQuery), pageable);
	}
	
	private Specification<Reply> getWhereClause(final ReplyQuery replyQuery) {
		
		return new Specification<Reply>() {
			@Override
			public Predicate toPredicate(Root<Reply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				List<Expression<Boolean>> exList = predicate.getExpressions();
				
				exList.add(cb.greaterThan(root.<Integer>get("replyParentid"), 0));
				if (replyQuery.getUserName()!=null&&"".equals(replyQuery.getUserName())) {
					exList.add(cb.like(root.<String>get("userName"), "%" + replyQuery.getUserName() + "%"));
				}

				return predicate;
			}

		};
	}

}
