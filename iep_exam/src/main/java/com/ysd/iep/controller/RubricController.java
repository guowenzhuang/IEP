package com.ysd.iep.controller;


import com.ysd.iep.dao.AnswerDao;
import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Answer;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.feign.Course;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.service.RubricService;
import com.ysd.iep.util.Cors;
import com.ysd.iep.util.Result;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rubric")
public class RubricController {
    @Autowired
    private RubricDao rubricdao;
    @Autowired
    private AnswerDao answerdao;
    @Autowired
    private RubricService rubricService;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    /**
     * 新增一道题干,以及选项
     *
     * @param addrubricquery
     * @return
     */
    @RequestMapping(value = "/addrubric", method = RequestMethod.POST)
    public Object addrubric(AddrubricQuery addrubricquery) {
        return rubricService.addrubric(addrubricquery);

    }

    /**
     * 根据userid查询课程列表
     */
    @GetMapping(value = "/getcourser")
    private Result<List<Course>> getCouse(@RequestParam("teaId") String teaId) {
        return teacherFeign.getCouse(teaId);
    }

    /**
     * 查询所有试题
     *
     * @return
     */
    @RequestMapping(value = "/queryrubricer", method = RequestMethod.POST)
    public Object queryrubricer(RubricQuery rubricquery, Integer page, Integer rows) {

        Page<Rubric> rubric = rubricService.queryUserByuserQuery(rubricquery, page, rows);
        Integer total = (int) rubric.getTotalElements();
        List<Rubric> list = rubric.getContent();

        list.forEach(item -> {
            item.getAnswer().forEach(t -> {
                t.setRubric(null);
            });
        });
        System.out.println(list);

        return new RubricFan(total, list);
    }

    /**
     * 删除题干以及选项
     *
     * @param id
     * @return Result
     */
    @RequestMapping(value = "/deleteredicbyid", method = RequestMethod.POST)
    public Object deleteredicbyid(String id) {
        return rubricService.deleteredicbyid(id);
    }

    /**
     * 修改试题(三种试题的修改)
     */
    @RequestMapping(value = "/updateredicbyid", method = RequestMethod.POST)
    public Object updateredicbyid(UpdaterubricQuery updaterubricquery) {


        return rubricService.updateredicbyid(updaterubricquery);
    }


}
