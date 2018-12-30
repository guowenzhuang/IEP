package com.ysd.iep.controller;


import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.dao.SectionexamrubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.entity.parameter.SectionFan;
import com.ysd.iep.service.RubricService;
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
    @Autowired
    RubricService rubricservice;
    @Autowired
    SectionexamparperDao sectionexamparperdao;


    /**
     * 根据课程章节查询章节测试试卷
     */
    @RequestMapping(value = "/selectsection", method = RequestMethod.POST)
    public Sectionexamparper selectsection(String course, String section) {
        return sectionexamparperdao.selectsectionparperwherecourseandsection(course, section);
    }

    /**
     * 多条件查询
     *
     * @return
     */
    @RequestMapping(value = "/querysectionrubric", method = RequestMethod.POST)
    public Object querysectionrubric(RubricQuery rubricquery, Integer page, Integer rows) {
        Page<Sectionexamrubric> sectionexamrubricPage = sectionrubricservice.queryUserByuserQuery(rubricquery, page, rows);
        System.out.println("分页数据*******************" + sectionexamrubricPage);
        Integer total = (int) sectionexamrubricPage.getTotalElements();
        List<Sectionexamrubric> list = sectionexamrubricPage.getContent();


        list.forEach(item -> {
            item.setSectionexamparper(null);
            item.getExamanswers().forEach(t -> {
                t.setSectionexamrubric(null);
            });
        });

        return new SectionFan(total, list);
    }


    /**
     * 新增试题
     */
    @RequestMapping(value = "/addexamrubric", method = RequestMethod.POST)
    public Object addexamrubric(AddrubricQuery addrubricquery) {
        return sectionrubricservice.addexamrubric(addrubricquery);
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


    /**
     * 新增考试试题(三中试题) 同时向题库中插入数据
     */
    @RequestMapping(value = "/addexamrubricdouble", method = RequestMethod.POST)
    public Result addexamrubricdouble(AddrubricQuery addrubricquery) {
        Result examrubricresult = null;
        Result examrubricresultdouble = null;
        Result rubricresult = rubricservice.addrubric(addrubricquery);


        if (addrubricquery.getRubrictype().equals("填空题") || addrubricquery.getRubrictype().equals("判断题")) {
            System.out.println("填空判断调用的");
            examrubricresult = sectionrubricservice.addexamrubric(addrubricquery);
        } else {
            System.out.println("单选多选调用的");
            examrubricresultdouble = sectionrubricservice.addexamrubricjudegepack(addrubricquery);
        }

        /*examrubricresult.isSuccess();*/
        if (rubricresult.isSuccess() || examrubricresult.isSuccess() || examrubricresultdouble.isSuccess()) {
            return new Result(true, "新增考试以及新增题库题成功!!!!", null);
        } else {
            return new Result(false, "新增考试以及新增题库题失败!!!!", null);
        }
    }


    /**
     * 进入章节测试的时候(返回卷子中的试题)
     */
/*
    @RequestMapping(value = "/addexamrubricdouble", method = RequestMethod.POST)
*/


}
