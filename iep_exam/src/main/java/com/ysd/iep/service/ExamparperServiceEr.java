package com.ysd.iep.service;


import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Studentexamlog;
import com.ysd.iep.entity.parameter.LookparperQuery;
import com.ysd.iep.entity.parameter.Student;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试卷Service
 */
public interface ExamparperServiceEr {

    /**
     * 查看考试完成的考试卷子列表(教师)
     */
    List<Examparper> queryexamendparper(String userid);

    /**
     * 根据卷子的id查询考试过这张卷子的学生id的集合
     */
    List<Student> querstudentidforparperid(String parperid);


    /**
     * 根据学生id,试卷id查询学生的做题记录  查询试卷
     */
    List<LookparperQuery> querylogforstudentandparperid(String studentid, String parperid);


    /**
     * 刚刚进入考试的时候查询考试记录表中的内容,有就返回
     */
    List<Studentexamlog> querynewlogforstudentandparperid(String studentid, String parperid);


    /**
     * 查看考试结束的考试卷子列表(此学生参加过的考试卷子)
     */
    List<Examparper> queryexamendparperwherestudentid(String studentid, Integer courseid);

}
