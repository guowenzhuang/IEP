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
    @PostMapping("/deleteChapters")
    public Result deleteChapters(@RequestParam("chaId") Integer chaId) {
    	List<Chapters> list = chapRep.queryChildren(chaId);
    	if (list.size()>0) {
    		return new Result(false).setMessage("该章节下有子节点,不能被删除");
		} else {
			 chapterService.deleteChapters(chaId);
		     return new Result(true);
		}
    }
    
    @ApiOperation(value = "修改章节")
    @PostMapping("/deleteChapters")
    public Result updateChapters(Chapters chapters) {
        chapterService.updateCourse(chapters);
        return new Result(true);
    }
}
