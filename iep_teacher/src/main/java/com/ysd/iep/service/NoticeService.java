package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.notice;
import com.ysd.iep.entity.dto.PagingResult;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.query.NoticeQuery;

public interface NoticeService {
	
	
	 /**
     * 根据课程id查询课程公告信息
    * @param courId
    * @return
    */
	List<notice> queryNoticeByCourId(Integer courId);
	
	/**
	 * 条件分页查询
	 * @param noticeQuery
	 * @return
	 */
	public PagingResult<notice> query(NoticeQuery noticeQuery);
	
	/**
	 * 发布公告(添加)
	 * @param notice
	 * @return
	 */
	Result insertNotice(notice notice);
	
	/**
	 * 根据公告id删除公告
	 * @param noId
	 */
	void deleteNoticeBynoId(Integer noId);
	
	/**
	 * 修改公告
	 * @param notice
	 * @return
	 */
	Result updateNotice(notice notice);

}
