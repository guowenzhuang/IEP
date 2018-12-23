package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>, JpaSpecificationExecutor<Report> {

	/**
	 * 举报的添加
	 * 
	 * @param userId
	 * @param reply
	 * @param reportReason
	 * @return
	 */
	/*
	 * @Query(value =
	 * "INSERT INTO reporttb(user_id,reply_id,report_reason) VALUES(?1,?2,?3)",
	 * nativeQuery = true)
	 * 
	 * @Modifying
	 * 
	 * @Transactional public Integer insertReport(Integer userId, Integer reply,
	 * String reportReason);
	 */
	/**
	 * 根据帖子id的举报信息
	 * 
	 * @return
	 */
	@Query(value = "SELECT 	* FROM reporttb WHERE reply_id =?1", nativeQuery = true)
	public List<Report> getReportid(Integer replyId);

/**
 * 举报删除
 * @param reportId
 * @return
 */
	  @Query(value = "DELETE  FROM reporttb WHERE report_id=?1", nativeQuery = true)
	  @Modifying
	  @Transactional
	  public Integer deletereport(Integer reportId);
	 
}
