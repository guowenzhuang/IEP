package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Chapters;
import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.entity.dto.CourseRecord;
import com.ysd.iep.service.StudentRecordService;
import com.ysd.iep.util.PagingResult;
import com.ysd.iep.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     *根据学生id分页查询学生的学习记录
     * @param id
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/{id}")
    public PagingResult<CourseRecord> query(@PathVariable("id") String id, Integer page, Integer rows){
        return studentRecordService.query(id,page, rows);
    }

    @GetMapping("/queryChapter")
    public Result< List<Chapters>> queryChapter(Integer cid,String id){
        List<Chapters> chapters = studentRecordService.queryChapter(cid, id);
        return new Result< List<Chapters>>(true,chapters);
    }

    @PostMapping("/recordStuCha")
    public void recordStuCha(@RequestParam("id") String id,
                             @RequestParam("cid") Integer cid,
                             @RequestParam("chaId") Integer chaId,
                             @RequestParam("watch") Double watch){
        studentRecordService.recordStuCha(id, cid, chaId, watch);
    }
}
