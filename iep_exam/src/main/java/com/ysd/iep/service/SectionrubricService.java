package com.ysd.iep.service;


import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author gaohzongye
 * @date 2018/12/29
 * 章节测试Service
 */
public interface SectionrubricService {

    /**
     * 分页查询试题
     *
     * @return
     */
    Page<Sectionexamrubric> queryUserByuserQuery(RubricQuery rubricquery, Integer page, Integer rows);

    /**
     * 新增考试题干
     */
    Result addexamrubric(AddrubricQuery addrubricquery);

    /**
     * 新增考试题干(新增考试题(仅对新增多选单选))
     */
    Result addexamrubricjudegepack(AddrubricQuery addrubricquery);

    /**
     * 章节测试刚刚进入的时候(返回章节测试卷子 中的章节测试试题)
     */
    Object querysectionrubric(RubricQuery rubricQuery);

    /**
     * 考试过之后成绩处理(单题的改卷处理)
     */
    Object examend(ExamUltimately examUltimately);

    /**
     * 章节测试整张卷子做完之后的处理
     */
    Object examination(ExamUltimately examUltimately);




}
