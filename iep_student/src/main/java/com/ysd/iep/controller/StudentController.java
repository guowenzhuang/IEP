package com.ysd.iep.controller;

import com.ysd.iep.entity.vo.StudentVo;
import com.ysd.iep.feign.AdminFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ysd.iep.entity.Student;
import com.ysd.iep.entity.dto.StudentUserDTO;
import com.ysd.iep.service.StudentService;
import com.ysd.iep.util.Result;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired(required = false)
	private AdminFeign adminFeign;
	
	@ApiOperation(value = "根据学生Id修改用户信息")
    @PutMapping("/updateStudent")
    public Result<String> updateStudent(@RequestBody StudentUserDTO stuUser){
    	System.out.println(stuUser);
    	Result<String> user = adminFeign.updateUserById(stuUser.getId(),stuUser);
    	studentService.updateStudent(stuUser);
		return new Result(true).setMessage("成功");
    }
	
	 @ApiOperation(value = "根据学生Id查询学生信息")
	 @GetMapping("/QueryStudentByid")
	 public Result<StudentUserDTO> QueryStudentByid(String sid) {
		return new Result(true,studentService.queryStuUserById(sid));
	 }
	
	/***
	 * 添加
	 */
	@PostMapping("/addStudent")
	public Object addStudent(@RequestBody  Student student) {
		try {
			studentService.addStudent(student);
			
			return new Result(true, "添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(true, "添加失败");
		}
	}
	
	/**
	 * 移除
	 */
	@DeleteMapping("/deleteStudent")
	public Object deleteStudent(@RequestParam("sid") String sid) {
		System.out.println(sid);
		try {
			studentService.deleteStudent(sid);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(true, "删除失败");
		}
		
	}

	@GetMapping("/{id}")
	public Result<StudentVo> query(@PathVariable("id") String id){
		return studentService.query(id);
	}

	@GetMapping("/getByIds")
	public Result<List<Student>> getByIds(@RequestParam("ids") String ids){
		List<Student> byIds = studentService.getByIds(ids);
		return new Result<>(true,byIds);
	}

	@ApiOperation(value = "根据学生id")
	@PutMapping("/updateCredits")
	public Result updateCredits(@RequestParam("credits") Integer credits,@RequestParam("sid") String sid){
		try {
			studentService.updateCredits(credits,sid);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(true,"修改失败");
		}
	}



}
