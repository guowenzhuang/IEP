package com.ysd.iep.controller;


import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamrubricService;
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
     * 多条件分页查询所有考试试题
     */
    @RequestMapping(value = "/addexamrubric", method = RequestMethod.POST)
    public Object addexamrubric(AddrubricQuery addrubricquery) {
        return examrubricservice.addexamrubric(addrubricquery);

    }


}
