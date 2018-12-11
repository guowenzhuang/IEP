package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.Like;


public interface LikeRepository extends JpaRepository<Like, Integer>{
	
	@Query(value = "SELECT COUNT(*) FROM liketb WHERE user_id=?1 AND reply_id=?2", nativeQuery = true)
	public Integer getLikeNum(Integer userId,Integer replyId);

}
