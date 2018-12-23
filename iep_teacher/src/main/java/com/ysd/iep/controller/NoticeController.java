package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.notice;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/notice", tags="公告")
@RestController
@RequestMapping("/notice")
public class NoticeController {
	 @Autowired
	 private NoticeService noticeService;
	
	/**
     * @param courId
     * @return
     */
    @ApiOperation(value = " 根据课程id查询课程公告信息")
    @GetMapping("/queryNoticeByCourId")
    public Result<List<notice>> queryNoticeByCourId(@RequestParam("courId")Integer courId) {
    	return new Result<List<notice>>(true,noticeService.queryNoticeByCourId(courId));
    }


}
