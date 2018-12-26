package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value = "/cource", tags = "课程API")
@RestController
@RequestMapping("/cource")
public class CourseController {
    @Autowired
    private CourseService service;

    @ApiOperation("分页查询课程")
    @GetMapping
    public PagingResult<CourseDTO> query(CourseQuery courseQuery) {
        return service.query(courseQuery);
    }
}
