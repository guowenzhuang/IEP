package com.ysd.iep.controller;

import com.ysd.iep.service.CommentService;
import com.ysd.iep.service.StudentPartService;
import com.ysd.iep.service.StudyService;
import com.ysd.iep.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/judge", tags = "根据课程id判断是否删除API")
@RestController
@RequestMapping("/judge")
public class JudgeDeleteController {
    @Autowired
    private  CommentService commentService;
    @Autowired
    private  StudentPartService studentPartService;
    @Autowired
    private StudyService studyService;

    /**
     * 根据课程id判断能不能删除
     * @param cid
     * @return
     */
    @ApiOperation(value = "根据课程id查询评价记录判断是否删除")
    @GetMapping("getRecordByCid")
    public Result<String> getRecordByCid(@RequestParam("cid") Integer cid){
        if(studentPartService.findByCid(cid).size()>0){
            return new Result<>(false,"该课程已有学生报名，无法删除!");
        }else if(commentService.findByCid(cid).size()>0){
            return new Result<>(false,"该课程下有评价，请先移除评价!");
        }else if(studyService.findByCid(cid).size()>0){
            return new Result<>(false,"该课程有学生正在学习，无法删除!");
        }else{
            return new Result<>(true);
        }
    }

}
