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

    /**
     * 查询章节
     *
     * @return
     */
    @ApiOperation(value = "查询章节")
    @GetMapping("/queryChapter")
    public List<Chapters> queryChapter(Integer courId) {
        System.out.println("课程id>>>>>>>>>>" + courId);
        return chapterService.querychapterTree(courId);

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

    @ApiOperation(value = "修改章节")
    @PutMapping("/updateChapters")
    public Result updateChapters(Chapters chapters) {
        chapterService.updateCourse(chapters);
        return new Result(true);
    }
    @ApiOperation(value = "修改视频")
    @PostMapping("/updateChaViurlAtime")
    public Result updateChaViurlAtime(String chaViurl, String chaTime,String chaName, Integer courId){
        chapterService.updateChaViurlAtime(chaViurl,chaTime,chaName,courId);
        return new Result(true);
    }
}
