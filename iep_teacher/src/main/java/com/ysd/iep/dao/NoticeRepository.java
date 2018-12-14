package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.notice;

public interface NoticeRepository extends JpaRepository<notice, Integer>{
	 @Query(value = "SELECT n.* FROM noticetb n LEFT JOIN coursetb c ON n.no_courid=c.cour_id WHERE c.cour_id=?1", nativeQuery = true)
		public List<notice> queryNoticeByCourId(Integer courId);
}
