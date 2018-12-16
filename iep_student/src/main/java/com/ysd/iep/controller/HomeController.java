package com.ysd.iep.controller;


import com.ysd.iep.service.TeacherService;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.service.AdminService;

/**
 * 首页控制器
 * @author ASUS
 *
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private TeacherService teacherService;

	/**
	 * @GetMapping 查询
	 * @PutMapping 修改
	 * @PostMapping 添加
	 * @DeleteMapping 删除
	 * 获取分类
	 * @return
	 */
    /**
     * http://localhost:8060/api/student/home/getCategory
     * @return
     */
	@GetMapping("/getCategory")
	public Object getCategory() {
		return adminService.getCategory();
	}

	/**
	 *获取课程推荐
	 */
	@GetMapping("/")
	public Object queryTuiJian(){

		return "";
	}



	/**
	 * 查询老师
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/getTeachers")
	public Object getTeachers(int page,int size){

		return "";
	}
	

}
