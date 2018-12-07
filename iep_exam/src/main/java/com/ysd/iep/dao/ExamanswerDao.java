package com.ysd.iep.dao;

import com.ysd.iep.entity.Examanswer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhognye
 * @date 2018/12/7
 * 考试选项dao
 */
public interface ExamanswerDao extends JpaRepository<Examanswer,String> {
}
