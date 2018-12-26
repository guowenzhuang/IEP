package com.ysd.iep.controller;

import com.ysd.iep.entity.CommentDTO;
import com.ysd.iep.entity.StudentComment;
import com.ysd.iep.service.CommentService;
import com.ysd.iep.util.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * http://localhost:80/api/student/comment/queryCommentByCid
     */
    @GetMapping("/queryCommentByCid")
    public Object queryCommentByCid(Integer cid, Integer page, Integer size){
        Page<StudentComment> pageStu=commentService.queryCommentByCid(cid,page,size);
        List<StudentComment> rows=pageStu.getContent();
        return rows;
    }
    /**
     * 根据学生id查询课程评价
     * http://localhost:80/api/student/comment/queryCommentByCid
     */
    @GetMapping("/queryCommentBySid")
    public Object queryCommentBySid(@RequestParam("sid") String sid, @RequestParam("page")Integer page,@RequestParam("size") Integer size){
        Page<StudentComment> pageStu=commentService.queryCommentBySid(sid,page,size);
        List<StudentComment> rows=pageStu.getContent();
        Long total = pageStu.getTotalElements();
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", rows);
        return map;
    }

    /**
     * 发表评论
     * http://localhost:80/api/student/comment/addComment
     * @param comment
     * @return
     */
    @PostMapping("/addComment")
    public Object postCommentByCid(StudentComment comment ){
        System.out.println("评论"+comment);
      return commentService.addComment(comment);



    }





}
