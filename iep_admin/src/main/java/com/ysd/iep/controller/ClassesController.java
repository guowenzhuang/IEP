package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.ClassesDB;
import com.ysd.iep.entity.query.ClassQuery;
import com.ysd.iep.entity.vo.ClassVo;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.ClassesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/classes", tags="班级API")
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;
    @PostMapping
    public Result<String> add(@RequestBody ClassesDB classesDB){
        try {
            classesService.add(classesDB);
        } catch (DataIntegrityViolationException e) {
            return new Result<String>(false,e.getMessage());
        }
        return new Result<String>(true,"新增成功");
    }

    @GetMapping
    public PagingResult<ClassVo> query(ClassQuery classQuery) {
        return classesService.query(classQuery);
    }

    @PutMapping("/{id}")
    public Result<String> update(@PathVariable("id") String id,@RequestBody ClassesDB classesDB){
        try {
            classesDB.setId(id);
            classesService.update(classesDB);
        } catch (DataIntegrityViolationException e) {
            return new Result<String>(false,e.getMessage());
        }
        return new Result<String>(true,"修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
         classesService.delete(id);
        return new Result<String>(true,"删除成功");
    }
    @GetMapping("/queryAll")
    public List<ClassVo> queryAll(){
        return classesService.queryAll();
    }
}
