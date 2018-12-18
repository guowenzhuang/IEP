package com.ysd.iep.controller;


import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamrubricService;
import com.ysd.iep.service.RubricService;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * <p>
 * 考试试卷Controller层
 */
@RestController
@RequestMapping("/examrubric")
public class ExamrubricController {

    @Autowired
    ExamrubricService examrubricservice;
    @Autowired
    RubricService rubricservice;


    /**
     * 多条件分页查询所有考试试题
     */
    @RequestMapping(value = "/queryexamrubric", method = RequestMethod.POST)
    public ExamrubricFan queryexamrubric(RubricQuery rubricquery, Integer page, Integer rows) {
        Page<Examrubric> examrubric = examrubricservice.queryExamrubricByuserQuery(rubricquery, page, rows);
        Integer total = (int) examrubric.getTotalElements();
        List<Examrubric> list = examrubric.getContent();

        list.forEach(item -> {
            item.getExamanswers().forEach(t -> {
                t.setExamrubric(null);
            });
        });


        return new ExamrubricFan(total, list);
    }


    /**
     * 新增试题
     */
    @RequestMapping(value = "/addexamrubric", method = RequestMethod.POST)
    public Object addexamrubric(AddrubricQuery addrubricquery) {
        return examrubricservice.addexamrubric(addrubricquery);

    }

    /**
     * 删除考试试题中的试题(根据id)
     */
    @RequestMapping(value = "/deleteexamrubric", method = RequestMethod.POST)
    public Object deleteexamrubric(String examrubricid) {
        return examrubricservice.deleteexamrubric(examrubricid);
    }

    /**
     * 新增考试试题(三中试题) 同时向题库中插入数据
     */
    @RequestMapping(value = "/addexamrubricdouble", method = RequestMethod.POST)
    public Result addexamrubricdouble(AddrubricQuery addrubricquery) {
        Result examrubricresult = null;
        Result examrubricresultdouble = null;

        Result rubricresult = rubricservice.addrubric(addrubricquery);

        if (addrubricquery.getRubrictype() == "填空题" && addrubricquery.getRubrictype() == "判断题") {
            examrubricresult = examrubricservice.addexamrubric(addrubricquery);
        } else {
            examrubricresultdouble = examrubricservice.addexamrubricjudegepack(addrubricquery);
        }

        /*examrubricresult.isSuccess();*/
        if (rubricresult.isSuccess() || examrubricresult.isSuccess() || examrubricresultdouble.isSuccess()) {
            return new Result(true, "新增考试以及新增题库题成功!!!!", null);
        } else {
            return new Result(false, "新增考试以及新增题库题失败!!!!", null);
        }
    }


}
