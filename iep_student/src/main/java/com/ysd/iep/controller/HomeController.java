package com.ysd.iep.controller;


import com.ysd.iep.entity.Recommend;
import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.entity.dto.RecommendIndexDTO;
import com.ysd.iep.entity.query.UsersRoleQuery;
import com.ysd.iep.service.AdminService;
import com.ysd.iep.service.TeacherService;
import com.ysd.iep.util.BeanConverterUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
	@ApiOperation(value = "获取课程分类")
	@GetMapping("/getCategory")
	public Object getCategory() {
		return adminService.getCategory();
	}

	/**
	 *获取首页轮播
	 */
	@ApiOperation(value = "获取首页轮播")
	@GetMapping("/queryShuffling")
	public Object queryShuffling(){
		RecommendIndexDTO recommendIndexDTO=adminService.getRecommentIndex();
		List<Recommend> recommends001=recommendIndexDTO.getRecommend001();
		System.out.println("一号位数据："+recommends001.size());
		String r1ids="";
		for (Recommend r1 : recommends001) {
			if(r1ids ==""){
				r1ids= String.valueOf(r1.getCoursetId());
			}else {
				r1ids += "," + r1.getCoursetId();
			}
		}
		System.out.println("字符串："+r1ids);
		List<Course> list=teacherService.findCourseById(r1ids);
		return list;
	}

	/**
	 * 获取首页课程推荐
	 */
	@GetMapping("/getRecommended")
	public Object getRecommended(){
		RecommendIndexDTO recommendIndexDTO=adminService.getRecommentIndex();
		List<Recommend> recommends002=recommendIndexDTO.getRecommend002();
		String r2ids="";
		for (Recommend r2 : recommends002) {
			if(r2ids ==""){
				r2ids= String.valueOf(r2.getCoursetId());
			}else {
				r2ids += "," + r2.getCoursetId();
			}
		}
		System.out.println(r2ids);
		List<Course> list=teacherService.findCourseById(r2ids);
		return list;

	}

	/**
	 * 查询老师
	 * @param page
	 * @param size
	 * @return
	 */
	@ApiOperation(value = "查询老师信息")
	@GetMapping("/getTeachers")
	public Object getTeachers( UsersRoleQuery usersRoleQuery){
        System.out.println("取到的参数："+usersRoleQuery);
		Map map= BeanConverterUtil.objectToMap(usersRoleQuery);
		return adminService.getTeachers(map);
	}


}
