package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.notice;

public interface NoticeService {
	
	 /**
     * 根据课程id查询课程公告信息
    * @param courId
    * @return
    */
	List<notice> queryNoticeByCourId(Integer courId);

}
