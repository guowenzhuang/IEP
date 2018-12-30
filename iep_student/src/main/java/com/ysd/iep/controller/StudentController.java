package com.ysd.iep.controller;

import com.ysd.iep.entity.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ysd.iep.entity.Student;
import com.ysd.iep.service.StudentService;
import com.ysd.iep.util.Result;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
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
	

}
