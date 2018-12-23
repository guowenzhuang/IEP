package com.ysd.iep.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Report;


public interface ReportService {
	/**
	 * 举报的添加
	 */

/*	public Integer insertReport(Integer userId, Integer reply, String reportReason);*/
	 /**
		 * 根据帖子id的举报信息
		 */

	
	public List<Report> getReportid(Integer replyId);

	/**
	 * 举报删除
	 */
	public Integer deletereport(Integer reportId);
}
