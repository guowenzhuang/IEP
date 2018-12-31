package com.ysd.iep.controller;

import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.Result;
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
     * @param courseid
     * @param sectionid
     * @param parperid
     * @return
     */
    @RequestMapping(value = "/deletsectionforcourseidandsectionidparperid", method = RequestMethod.POST)
    public Result deletsectionforcourseidandsectionidparperid(Integer courseid, Integer sectionid, String parperid) {
        return sectionexamparperservice.deletsectionforcourseidandsectionidparperid(courseid, sectionid, parperid);
    }


}
