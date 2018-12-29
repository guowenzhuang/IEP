package com.ysd.iep.controller;


import com.ysd.iep.dao.SectionexamrubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.entity.parameter.SectionFan;
import com.ysd.iep.service.SectionrubricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试试题控制器
 */
@RestController
@RequestMapping("/Sectionrubric")
public class SectionrubricController {
    @Autowired
    SectionrubricService sectionrubricservice;
    @Autowired
    SectionexamrubricDao sectionexamrubricdao;

    /**
     * 多条件查询
     *
     * @return
     */
    @RequestMapping(value = "/querysectionrubric", method = RequestMethod.POST)
    public Object querysectionrubric(RubricQuery rubricquery, Integer page, Integer rows) {
        Page<Sectionexamrubric> sectionexamrubricPage = sectionrubricservice.queryUserByuserQuery(rubricquery, page, rows);
        Integer total = (int) sectionexamrubricPage.getTotalElements();
        List<Sectionexamrubric> list = sectionexamrubricPage.getContent();

        list.forEach(item -> {
            item.getExamanswers().forEach(t -> {
                t.setSectionexamrubric(null);
            });
        });
        return new SectionFan(list, total);
    }


    /**
     * 移除章节测试试题
     */
    @RequestMapping(value = "/deletesectionrubric", method = RequestMethod.POST)
    public Object deletesectionrubric(String sectionexamrubricid) {

        try {
            sectionexamrubricdao.deletforexamrubricid(sectionexamrubricid);
            return new Result(true, "移除章节测试试题成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "移除章节测试试题失败", null);
        }

    }


}
