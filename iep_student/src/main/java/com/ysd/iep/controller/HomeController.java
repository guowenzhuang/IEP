package com.ysd.iep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 首页控制器
 * @author ASUS
 *
 */
@RestController
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("/getMenu")
	public Object getMenu() {
		
		return "访问成功";
	}
	
	//调服务
	

}
