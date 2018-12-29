package com.ysd.iep.controller;


import com.ysd.iep.entity.Sectionexamrubric;
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

    @RequestMapping(value = "/querysectionrubric", method = RequestMethod.POST)
    public List<Sectionexamrubric> querysectionrubric() {
        return null;
    }
}
