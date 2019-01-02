package com.ysd.iep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.NoticeRepository;
import com.ysd.iep.entity.notice;
import com.ysd.iep.entity.dto.Result;
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


}
