package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersStuDTO;
import com.ysd.iep.entity.query.StudentQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/student", tags="学生API")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public PagingResult query(StudentQuery studentQuery){
        PagingResult query = studentService.query(studentQuery);
        return query;
    }
    @PostMapping
    public Result add(@RequestBody UsersStuDTO usersStuDTO){
        try {
            studentService.add(usersStuDTO);
        } catch (DataIntegrityViolationException e) {
            return new Result<String>(false,e.getMessage());
        }
        return new Result(true,"新增成功");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable("id") String id,@RequestBody UsersStuDTO usersStuDTO){
        try {
            usersStuDTO.setId(id);
            studentService.update(usersStuDTO);
        } catch (DataIntegrityViolationException e) {
            return new Result<String>(false,e.getMessage());
        }
        return new Result(true,"修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
        studentService.delete(id);
        return new Result<String>(true,"删除成功");
    }

}
