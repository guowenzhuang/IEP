package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersStuDTO;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.query.StudentQuery;
import com.ysd.iep.entity.query.UsersQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.StudentService;
import com.ysd.iep.service.UtilService;
import com.ysd.iep.util.ExcelUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UtilService utilService;
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

    @GetMapping("getTemplate")
    public List<Map> getTemplate(){
        return utilService.CheckBoxClassMapper(UsersStuDTO.class);
    }
    @GetMapping("expertTemplate")
    public void expertTemplate(HttpServletResponse response, String names){
        try {
            ExcelUtil.TemplateExprot(response,"学生模板.xlsx", Arrays.asList(names.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value="exports")
    public void exports(StudentQuery studentQuery, HttpServletResponse response){
        List<UsersStuDTO> exports = studentService.exports(studentQuery);
        try {
            ExcelUtil.exportExcel(response,"学生.xlsx",exports);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("import")
    public Result importStudent(MultipartFile file) throws IOException {
        try {
            studentService.importStudent(file);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }
        return new Result(true,"导入成功");

    }
}
