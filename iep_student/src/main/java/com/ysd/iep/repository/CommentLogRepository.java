package com.ysd.iep.repository;

import com.ysd.iep.entity.CommentLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLogRepository extends JpaRepository<CommentLog,Integer> {

 public CommentLog findByMidAndSid(Integer mid,String sid);
}
