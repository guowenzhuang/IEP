package com.ysd.iep.controller;

import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherDTO;
import com.ysd.iep.entity.dto.TeachersDTO;
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
    public Result<List<TeacherDTO>>  getAllTeacher(){
        List<String> list=teaRep.queryTeacherId();
        List<List<TeacherDTO>> tealist=new ArrayList<List<TeacherDTO>>();
        for (String string : list) {
        	Result<String> result = adminFeign.getNameById(string);
        	String name = result.getMessage();//获取单个教师姓名
        	List<TeacherDTO> tea = teachersService.queryTeacher(string);
        	System.out.println("tea>>>>>>>>>>>>>>>>"+tea);
        	tea.get(0).setTeaName(name);//把查询到的名字赋值给tea
        	  System.out.println("teaList>>>>>>>>>>>>"+tea);
        	  tealist.add(tea);
		}
		return new Result(true,tealist);
        
    }
    
    //
    @ApiOperation(value = "查询老师信息1")
    @GetMapping("/getAllT")
    public Result<List<TeachersDTO>>  getAllT(){
        List<String> list=teaRep.queryTeacherId();
        List<List<TeacherDTO>> tealist=new ArrayList<List<TeacherDTO>>();
        for (String string : list) {
        	Result<String> result = adminFeign.getNameById(string);
        	String name = result.getMessage();//获取单个教师姓名
        	List<TeacherDTO> tea = teachersService.queryTeachers(string);
        	System.out.println("tea>>>>>>>>>>>>>>>>"+tea);
        	tea.get(0).setTeaName(name);//把查询到的名字赋值给tea
        	  System.out.println("teaList>>>>>>>>>>>>"+tea);
        	  tealist.add(tea);
		}
		return new Result(true,tealist);
        
    }
	

}
