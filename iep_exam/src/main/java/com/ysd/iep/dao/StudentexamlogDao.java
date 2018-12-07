package com.ysd.iep.dao;

import com.ysd.iep.entity.Studentexamlog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhognye
 * @date 2018/12/7
 * 学生考试记录表dao
 */
public interface StudentexamlogDao extends JpaRepository<Studentexamlog, String> {
}
