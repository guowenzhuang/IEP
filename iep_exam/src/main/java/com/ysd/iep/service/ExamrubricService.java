package com.ysd.iep.service;

import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.*;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;

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
     * 根据试卷id查询考试试题
     */
    List<Examrubric> getExamrubricforparperid(RubricQuery rubricquery);

    /**
     * 新增考试题干
     */
    Result addexamrubric(AddrubricQuery addrubricquery);

    /**
     * 新增考试题干(新增考试题(仅对新增多选单选))
     */
    Result addexamrubricjudegepack(AddrubricQuery addrubricquery);

    /**
     * 考试试题的删除
     */
    Object deleteexamrubric(String examrubricid);

    /**
     * 点击创建试卷(获取多有题型的数量信息,存入到parper表中)
     */
    Result createparper(String parperid);

    /**
     * 点击开始考试按钮
     */
    Result beginexam(BeginexamQuery beginexamQuery) throws ParseException;

    /**
     * 根据试卷id获取试卷信息
     *
     * @return
     */
    List<Examrubric> queryexamrubric(RubricQuery rubricQuery);

}
