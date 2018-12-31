package com.ysd.iep.service;

import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.Result;

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

}

