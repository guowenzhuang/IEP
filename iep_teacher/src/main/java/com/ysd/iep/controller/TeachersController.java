package com.ysd.iep.controller;

import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherDTO;
import com.ysd.iep.entity.dto.TeacherUserDTO;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.TeachersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping
    public Result<List<Teachers>> get(@RequestParam("teaid") String teaids){
        String[] ids=teaids.split(",");
        List<Teachers> teachers=teaRep.findById(ids);
        return new Result<List<Teachers>>(true,teachers);
    }

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

    @ApiOperation(value = "查询老师信息")
    @GetMapping("/QueryTeacher")
    public Result<List<TeacherUserDTO>> QueryTeacher() { 
		return new Result(true,teachersService.getTeaUser());
    }
    
    @ApiOperation(value = "根据教师Id查询老师信息")
    @GetMapping("/QueryTeacherByid")
    public Result<TeacherUserDTO> QueryTeacherByid(String id) {
		return new Result(true,teachersService.queryTeaUserById(id));
    }

    @ApiOperation(value = "根据教师Id修改老师信息")
    @PutMapping("/updateTeacher")
    public Result<String> updateTeacher(@RequestBody TeacherUserDTO teauser){
    	System.out.println("教师参数信息>>>>>>>>"+teauser.getProtectEMail());
    	System.out.println("教师参数信息2>>>>>>>>"+teauser.getProtectMTel());
    	Result<String> user = adminFeign.updateUserById(teauser);
    	String result = user.getMessage();
    	 teachersService.updateTeacher(teauser);
		return new Result(true).setMessage("成功");
    	
    }

}
