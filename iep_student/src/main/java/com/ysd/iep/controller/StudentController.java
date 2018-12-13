package com.ysd.iep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Student;
import com.ysd.iep.service.StudentService;
import com.ysd.iep.util.Result;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/***
	 * 添加
	 */
	@PostMapping("/addStudent")
	public Object addStudent(Student student) {
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
	public Object deleteStudent(String sid) {
		
		try {
			studentService.deleteStudent(sid);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(true, "删除失败");
		}
		
	}
	

}
