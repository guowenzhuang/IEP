package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ysd.iep.dao.ChapterRepository;
import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.ChapterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/chapter", tags = "章节")
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ChapterRepository chapRep;
    
   
    @ApiOperation(value = "根据Id查询父章节")
    @GetMapping("/queryParentChapter")
    public Result<List<Chapters>> queryParentChapter(Integer courId){
    	return new Result(true,chapterService.queryParentchapter(courId));
    }

    
    @ApiOperation(value = "查询章节")
    @GetMapping("/queryChapter")
    public List<Chapters> queryChapter(Integer courId) {
        System.out.println("课程id>>>>>>>>>>" + courId);
        return chapterService.querychapterTree(courId);
    }

    @GetMapping("/{id}")
    public Chapters get(@PathVariable("id") Integer id){
        return  chapterService.get(id);
    }

    @ApiOperation(value = "增加章节")
    @PostMapping("/addChapters")
    public Result addChapters(Chapters chapters) {
        chapterService.insertChapters(chapters);
        return new Result(true);
    }

    @ApiOperation(value = "删除章节")
    @DeleteMapping("/{chaId}")
    public Result deleteChapters(@PathVariable("chaId") Integer chaId) {
        return chapterService.deleteChapters(chaId);
    }

    @ApiOperation(value = "根据章节id修改视频的路径和视频的时长")
    @PostMapping("/updateChapters")
    public Result updateChapters(Chapters chapters) {
        chapterService.updateCourse(chapters);
        return new Result(true);
    }
    @ApiOperation(value = "根据课程Id查询章节的总条数")
    @GetMapping("/queryCountById")
    public Result queryCountById(Integer chaCourid) {
        chapterService.queryCountById(chaCourid);
        return new Result(true);
    }
}
