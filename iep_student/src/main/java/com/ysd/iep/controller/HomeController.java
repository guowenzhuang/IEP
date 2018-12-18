package com.ysd.iep.controller;


import com.ysd.iep.entity.Recommend;
import com.ysd.iep.entity.dto.RecommendIndexDTO;
import com.ysd.iep.service.AdminService;
import com.ysd.iep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
	@GetMapping("/queryTuiJian")
	public Object queryTuiJian(){
		RecommendIndexDTO recommendIndexDTO=adminService.getRecommentIndex();
		List<Recommend> recommends001=recommendIndexDTO.getRecommend001();
		System.out.println("一号位数据："+recommends001.size());

		List<Integer> r1Ids= new ArrayList<Integer>();
		for (Recommend r1 : recommends001) {
			r1Ids.add(r1.getCoursetId());
		}


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
