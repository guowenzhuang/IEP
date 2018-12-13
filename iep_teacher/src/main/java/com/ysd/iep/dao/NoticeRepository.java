package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.notice;

public interface NoticeRepository extends JpaRepository<notice, Integer>{
	 @Query(value = "SELECT n.* FROM notice n LEFT JOIN course c ON n.noCourid=c.courId WHERE c.courId=2", nativeQuery = true)
		public List<notice> queryNoticeByCourId(Integer courId);
}
