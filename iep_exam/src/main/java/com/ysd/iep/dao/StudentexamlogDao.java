package com.ysd.iep.dao;

import com.ysd.iep.entity.Studentexamlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhognye
 * @date 2018/12/7
 * 学生考试记录表dao
 */
public interface StudentexamlogDao extends JpaRepository<Studentexamlog, String> {

    @Query(value = "SELECT *from studentexamlog_tb where examparper_id=?1", nativeQuery = true)
    public List<Studentexamlog> selecttotalforparperid(String parperid);
}
