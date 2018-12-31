package com.ysd.iep.dao;

import com.ysd.iep.entity.Performance;
import com.ysd.iep.entity.Studentexamlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 成绩表dao
 */
public interface PerformanceDao extends JpaRepository<Performance, String> {

    @Query(value = "SELECT * from performance_tb where parper_id =?1 and student_id =?2", nativeQuery = true)
    Performance selectperformanforparperidandstudentid(String parperid, String studentid);


    @Query(value = "SELECT * from performance_tb where parper_id =?1", nativeQuery = true)
    List<Performance> selectperformanforparperid(String parperid);

    @Query(value = "SELECT * from performance_tb where parper_id =?1 and student_id =?2", nativeQuery = true)
    List<Performance> selectperformanforparperidandstudentider(String parperid, String studentid);


}


