package com.ysd.iep.dao;

import com.ysd.iep.entity.Examparper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试试卷dao
 */

public interface ExamparperDao extends JpaRepository<Examparper, String>, JpaSpecificationExecutor<Examparper> {

    /***
     * 查询本门课程下的未开考测试试卷
     * @param subject
     * @return
     */
    @Query(value = "select * FROM examparper_tb where state in ('未开考','考试中') AND `subject`=?1", nativeQuery = true)
    List<Examparper> querySubjectAndState(String subject);

    /**
     * 查询这个教师旗下的卷子
     *
     * @param userid
     * @return
     */
    @Query(value = "SELECT *from examparper_tb where state='考试结束' AND techer_id=?1", nativeQuery = true)
    List<Examparper> queryexamendforuserid(String userid);

    /***
     * 根据课程Id查询试卷
     * @param coureId
     * @return
     */
    List<Examparper> findBySubject(String coureId);

}