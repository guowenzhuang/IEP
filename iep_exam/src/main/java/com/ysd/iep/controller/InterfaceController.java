package com.ysd.iep.controller;

import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.serviceimpl.QueryTestQuestionBankInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "/InterfaceController", tags = "查询测试题库试卷接口")
@RestController
@RequestMapping("/InterfaceController")
public class InterfaceController {
    @Autowired
    private QueryTestQuestionBankInterface queryTestQuestionBankInterface;
    @ApiOperation(value = "根据课程Id查询测试题库试卷")
    @GetMapping("/query")
    public Result query(Integer coureId){
        return queryTestQuestionBankInterface.query(coureId);
    }
}
