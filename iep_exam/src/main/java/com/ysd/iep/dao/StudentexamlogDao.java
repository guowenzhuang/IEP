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

    /**
     * 查询所有的考试记录根据考试试卷id
     *
     * @param parperid
     * @return
     */
    @Query(value = "SELECT *from studentexamlog_tb where examparper_id=?1", nativeQuery = true)
    public List<Studentexamlog> selecttotalforparperid(String parperid);

    /**
     * 根据考试试题题干id查询记录(判断是否存在)
     *
     * @param examrubricid
     * @return
     */
    @Query(value = "SELECT *from studentexamlog_tb where examrubric_id=?1 and student_id=?2", nativeQuery = true)
    public Studentexamlog selectlogforexamrubricid(String examrubricid,String studentid);


    /**
     * 根据学生id查询出学生考试过的卷子
     */
    @Query(value = "SELECT *from studentexamlog_tb where student_id=?1 and course_id=?2", nativeQuery = true)
    public List<Studentexamlog> selectlogforstudentid(String studentid,Integer courseid);

    /**
     * 根据学生id和卷子id查询做题记录
     *
     * @param studentid
     * @return
     */
    @Query(value = "SELECT *from studentexamlog_tb where student_id=?1 and examparper_id=?2", nativeQuery = true)
    public List<Studentexamlog> selectlogforstudentidandparperid(String studentid, String parperid);


}

/**
 * 36.96
 * 36.82
 */
