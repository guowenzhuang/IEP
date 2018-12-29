package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.ClassesDB;
import com.ysd.iep.service.ClassesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/classes", tags="班级API")
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @PostMapping
    public Result<String> add(@RequestBody ClassesDB classesDB){
        classesService.add(classesDB);
        return new Result<String>(true,"新增成功");
    }
}
