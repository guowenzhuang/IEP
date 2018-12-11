package com.ysd.iep.controller;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.service.AdminService;

import lombok.Delegate;
/**
 * 首页控制器
 * @author ASUS
 *
 */
@RestController
@RequestMapping("/home")
public class HomeController {
	
	/*@Autowired
	private AdminService adminService;*/
	/**
	 * @GetMapping 查询
	 * @PutMapping 修改
	 * @PostMapping 添加
	 * @DeleteMapping 删除
	 * 获取分类
	 * @return
	 */
	
	@GetMapping("/getCategory")
	public Object getCategory() {
		
		return "访问成功";
	}
	
	//调服务
	

}
