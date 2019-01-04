package com.ysd.iep.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.NoticeRepository;
import com.ysd.iep.entity.notice;
import com.ysd.iep.entity.dto.PagingResult;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.query.NoticeQuery;
import com.ysd.iep.service.NoticeService;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeRepository noticedao;

	/**
	 * 根据课程id查询课程公告信息
	 */
	@Override
	public List<notice> queryNoticeByCourId(Integer courId) {
		// TODO Auto-generated method stub
		List<notice> notice = noticedao.queryNoticeByCourId(courId);
		return notice;
	}

	/**
	 * 发布公告(添加)
	 */
	@Override
	public Result insertNotice(notice notice) {
		// TODO Auto-generated method stub
		noticedao.save(notice);
		return new Result(true);
	}

	/**
	 * 根据id删除公告
	 */
	@Override
	public void deleteNoticeBynoId(Integer noId) {
		// TODO Auto-generated method stub
		noticedao.deleteById(noId);
	}

	/**
	 * 修改公告信息
	 */
	@Override
	public Result updateNotice(notice notice) {
		// TODO Auto-generated method stub
		noticedao.save(notice);
		return new Result(true);
	}

	/**
	 * 条件分页查询课程公告
	 */
	@Override
	public PagingResult<notice> query(NoticeQuery noticeQuery) {
		Specification<notice> specification = where(noticeQuery);
		// 排序分页
		Pageable pageable = null;
		if (EmptyUtil.stringE(noticeQuery.getOrder())) {
			Sort sort = new Sort(Sort.Direction.DESC, noticeQuery.getOrder());
			pageable = PageRequest.of(noticeQuery.getPage() - 1, noticeQuery.getRows(), sort);
		} else {
			pageable = PageRequest.of(noticeQuery.getPage() - 1, noticeQuery.getRows());
		}
		Page<notice> nitices = noticedao.findAll(specification, pageable);
		List<notice> noticeList = nitices.getContent();
		PagingResult<notice> pagingResult = new PagingResult<notice>();
		pagingResult.setTotal(nitices.getTotalElements()).setRows(BeanConverterUtil.copyList(noticeList, notice.class));
		return pagingResult;
	}

	/**
	 * 条件查询公告封装条件
	 * 
	 * @param noticeQuery
	 * @return
	 */
	private Specification<notice> where(NoticeQuery noticeQuery) {
		Specification<notice> specification = new Specification<notice>() {
			@Override
			public Predicate toPredicate(Root<notice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 标题模糊查询
				if (EmptyUtil.stringE(noticeQuery.getNoTitle())) {
					Path<String> titlePath = root.get("noTitle");
					predicates.add(criteriaBuilder.like(titlePath, "%" + noticeQuery.getNoTitle() + "%"));
				}
				if (noticeQuery.getNoCourid() != null) {
					Path<Integer> noCourid = root.get("noCourid");
					predicates.add(criteriaBuilder.equal(noCourid, noticeQuery.getNoCourid()));
				}
				// 创建时间查询
				Path<Timestamp> createTimePath = root.get("noCreattime");
				if (EmptyUtil.dateE(noticeQuery.getBeginCreateTime())) {
					predicates.add(
							criteriaBuilder.greaterThanOrEqualTo(createTimePath, noticeQuery.getBeginCreateTime()));
				}
				if (EmptyUtil.dateE(noticeQuery.getEndCreateTime())) {
					predicates.add(criteriaBuilder.lessThanOrEqualTo(createTimePath, noticeQuery.getEndCreateTime()));
				}

				Predicate[] p = new Predicate[predicates.size()];
				return criteriaBuilder.and(predicates.toArray(p));
			}
		};
		PageRequest pageRequest = null;
		if (EmptyUtil.stringE(noticeQuery.getOrder())) {
			Sort sort = new Sort(Sort.Direction.DESC, noticeQuery.getOrder());
			pageRequest = PageRequest.of(noticeQuery.getPage() - 1, noticeQuery.getRows(), sort);
		} else {
			pageRequest = PageRequest.of(noticeQuery.getPage() - 1, noticeQuery.getRows());
		}
		return specification;
	}

	/**
	 * 
	 */
	@Override
	public Result<String> findByCourId(Integer courId) {
		 List<Integer> byNoCourid = noticedao.findByCourId(courId);
		 System.out.println(byNoCourid+"aaaaaaaaaa");
	        if(byNoCourid==null || byNoCourid.size()==0){
	            return new Result<>(true);
	        }else{
	            return new Result<>(false,"此课程有公告不能删除");
	        }
	}

}
