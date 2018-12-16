package com.ysd.iep.controller;

import com.ysd.iep.entity.CommentDTO;
import com.ysd.iep.entity.StudentComment;
import com.ysd.iep.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/comment", tags="评价")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/queryOrder")
    public Page<CommentDTO> queryOrder(@RequestParam("page") Integer page,@RequestParam("size") Integer size,@RequestParam("orderBy") String orderBy){
        return commentService.queryAllPage(page, size, orderBy);
    }

    /**
     * 查询课程评价
     */
    @GetMapping("/queryCommentByCid")
    public Page<StudentComment> queryCommentByCid(Integer cid, Integer page, Integer size){

        return commentService.queryCommentByCid(cid,page,size);

    }




}
