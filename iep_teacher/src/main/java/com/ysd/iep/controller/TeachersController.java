package com.ysd.iep.controller;

import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;


import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.TeachersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="/tea", tags="教师")
@RestController
@RequestMapping("/tea")
public class TeachersController {
    @Autowired
  private TeachersService teachersService;
    @Autowired
    private AdminFeign adminFeign;
    @Autowired
    private TeacherRepository teaRep;
    @ApiOperation(value = "增加老师")
    @PostMapping("/addTeacher")
    public Result<String> AddTeacher(@RequestParam("teaId") String teaId){
    	if (teaId != null && teaId != "") {
    		teachersService.insertTeacher(teaId);
    		return new Result(true,"成功");
    	}else {
    		return new Result(false,"失败");
    	}
        
    }
    @ApiOperation(value = "根据id删除老师")
    @DeleteMapping("/deleteTeacherById")
    public Result<String> deleteTeacherById(@RequestParam("teacherId")String teacherId) {
    	teachersService.deleteTeacherById(teacherId);
		return new Result(true).setMessage("成功");
    	
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "查询老师信息")
    @GetMapping("/getAllTeacher")
    public Result  getAllTeacher(){
        List<String> list=teaRep.queryTeacherId();
        String ids = String.join(",", list);
        System.out.println("获取的教师ID>>>>>"+ids);
        Result<List<UsersDTO>> user = adminFeign.getUserById(ids);
        System.out.println("用户信息>>>>>>>"+user);
        return new Result(true);
    }

}
