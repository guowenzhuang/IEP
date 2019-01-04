package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.notice;

public interface NoticeRepository extends JpaRepository<notice, Integer>,JpaSpecificationExecutor<notice>{
	/**
	 * 根据课程id查询课程公告信息
	 * @param courId
	 * @return
	 */
	 @Query(value = "SELECT * FROM noticetb WHERE no_courid =?1 ORDER BY no_creattime DESC", nativeQuery = true)
		public List<notice> queryNoticeByCourId(Integer courId);
		
		
}
