package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ysd.iep.entity.notice;
import com.ysd.iep.entity.dto.PagingResult;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.query.NoticeQuery;
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
    
    /**
     * 
     * @return
     */
    @ApiOperation(value = "条件分页查询公告")
    @GetMapping("/query")
    public PagingResult<notice> query(NoticeQuery noticeQuery){
    	return noticeService.query(noticeQuery);
    }
    /**
     * 发布公告(添加)
     * @param notice
     * @return
     */
    @ApiOperation(value = "教师发布公告")
    @PostMapping("/insertNotice")
    public Result<String> insertNotice(notice notice) {
    	noticeService.insertNotice(notice);
    	return new Result(true).setMessage("发布成功！");
    }
    
    /**
     * 根据id删除公告
     * @param noId
     */
    @ApiOperation(value = "教师删除公告")
    @DeleteMapping("/deleteNoticeBynoId")
    public Result<String> deleteNoticeBynoId(@RequestParam("noId")Integer noId) {
    	noticeService.deleteNoticeBynoId(noId);
    	return new Result(true).setMessage("删除成功！");
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @ApiOperation(value = "教师修改公告")
    @PutMapping("/updateNotice")
    public Result<String> updateNotice(@RequestBody notice notice) {
    	System.out.println(notice);
    	noticeService.updateNotice(notice);
    	return new Result(true).setMessage("修改成功！");
    }
}
