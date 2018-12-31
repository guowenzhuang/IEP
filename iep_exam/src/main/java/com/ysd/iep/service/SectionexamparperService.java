package com.ysd.iep.service;

import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.LookparperQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.SectionexamQuery;
import com.ysd.iep.entity.parameter.permanceFan;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/30
 * 章节测试试卷service
 */
public interface SectionexamparperService {

    /**
     * 根据课程id 章节id查询 章节测试试卷
     */
    List<Sectionexamparper> selectparperforcoueseidandsectionid(Integer courseid, Integer sectionid);

    /**
     * 根据课程id 章节id 章节测试parperid 删除卷子
     */
    Result deletsectionforcourseidandsectionidparperid(Integer courseid, Integer sectionid, String parperid);

    /**
     * 根据章节考试试卷id 查看章节测试题目
     */
    List<LookparperQuery> selectsectionparperrubric(String parperid);

    /**
     * 根据课程查询所有的父章节   以及根据课程id查询所有的试卷
     */
    SectionexamQuery selectsectionandparper(Integer courseid);

    /**
     * 根据章节测试卷子id 学生id查询出所有的成绩记录,返回测验的次数  以及最高的分数 ,以及最近一次提交的时间
     */
    permanceFan selecttotalandnumandmaxtotal(String parperid, String studentid);


}

