package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.entity.dto.CourseRecord;
import com.ysd.iep.service.StudentRecordService;
import com.ysd.iep.util.PagingResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value = "/studentrecord", tags = "学生学习记录API")
@RestController
@RequestMapping("/studentrecord")
public class StudentRecordController {
    @Autowired
    private StudentRecordService studentRecordService;
    @GetMapping("/{id}")
    public PagingResult<CourseRecord> query(@PathVariable("id") String id, Integer page, Integer rows){
        return studentRecordService.query(id,page, rows);
    }
}
