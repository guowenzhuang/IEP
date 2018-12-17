package com.ysd.iep.service;

import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.RubricQuery;
import org.springframework.data.domain.Page;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试题service
 */
public interface ExamrubricService {


    /**
     * 试卷试题的多条件分页查询
     */
    Page<Examrubric> queryExamrubricByuserQuery(RubricQuery rubricquery, Integer page, Integer rows);


    /**
     * 新增考试题干
     */
    Object addexamrubric(AddrubricQuery addrubricquery);


}
