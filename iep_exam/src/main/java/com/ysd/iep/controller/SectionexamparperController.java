package com.ysd.iep.controller;

import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.LookparperQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.SectionexamQuery;
import com.ysd.iep.entity.parameter.permanceFan;
import com.ysd.iep.service.SectionexamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sectionparper")
public class SectionexamparperController {
    @Autowired
    SectionexamparperService sectionexamparperservice;

    /**
     * 根据课程id 章节id查询 章节测试试卷
     */
    @RequestMapping(value = "/querysectionparper", method = RequestMethod.POST)
    public List<Sectionexamparper> querysectionparper(Integer course, Integer section) {
        return sectionexamparperservice.selectparperforcoueseidandsectionid(course, section);

    }

    /**
     * 根据课程id,章节id章节测试试卷id删除试卷
     *
     * @param course
     * @param section
     * @param parperid
     * @return
     */
    @RequestMapping(value = "/deletsectionforcourseidandsectionidparperid", method = RequestMethod.POST)
    public Result deletsectionforcourseidandsectionidparperid(Integer course, Integer section, String parperid) {

        return sectionexamparperservice.deletsectionforcourseidandsectionidparperid(course, section, parperid);
    }


    /**
     * 根据章节考试试卷id 查看章节测试题目
     */
    @RequestMapping(value = "/selectsectionparperrubric", method = RequestMethod.POST)
    public List<LookparperQuery> selectsectionparperrubric(String parperid) {
        return sectionexamparperservice.selectsectionparperrubric(parperid);
    }


    /**
     * 根据课程查询所有的父章节   以及根据课程id查询所有的试卷
     */
    @RequestMapping(value = "/selectsectionparperrubricer", method = RequestMethod.POST)
    public SectionexamQuery selectsectionparperrubricer(Integer courseid) {
        return sectionexamparperservice.selectsectionandparper(courseid);
    }

    /**
     * 根据章节测试卷子id 学生id查询出所有的成绩记录,返回测验的次数  以及最高的分数 ,以及最近一次提交的时间
     */
    @RequestMapping(value = "/selecttotalandnumandmaxtotal", method = RequestMethod.POST)
    public permanceFan selecttotalandnumandmaxtotal(String parperid, String studentid) {
        return sectionexamparperservice.selecttotalandnumandmaxtotal(parperid, studentid);
    }

    
}
