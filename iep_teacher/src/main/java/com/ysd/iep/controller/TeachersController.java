package com.ysd.iep.controller;

import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;

import com.ysd.iep.service.TeachersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="/tea", tags="教师")
@RestController
@RequestMapping("/tea")
public class TeachersController {
    @Autowired
  private TeachersService teachersService;
    @ApiOperation(value = "增加老师")
    @PostMapping("/addTeacher")
    public Result AddTeacher(Teachers teachers){
        teachersService.insertTeacher(teachers);
        return new Result(true);
    }
}
