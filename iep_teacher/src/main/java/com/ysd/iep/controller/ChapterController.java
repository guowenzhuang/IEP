package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.ChapterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/chapter", tags="章节")
@RestController
@RequestMapping("/chapter")
public class ChapterController {

	    @Autowired
	    private ChapterService chapterService;
	    
	    /**
	     * 查询章节
	     * @return
	     */
	    @ApiOperation(value = "查询章节")
	    @GetMapping("/queryChapter")
	    public List<Chapters> queryChapter(Integer courId) {
	    	System.out.println("课程id>>>>>>>>>>"+courId);
			return chapterService.querychapterTree(courId);
	    	
	    }
}
