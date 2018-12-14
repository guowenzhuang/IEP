package com.ysd.iep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.NoticeRepository;
import com.ysd.iep.entity.notice;
import com.ysd.iep.service.NoticeService;

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


}
