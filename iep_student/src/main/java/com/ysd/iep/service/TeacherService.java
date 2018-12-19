package com.ysd.iep.service;

import com.ysd.iep.entity.dto.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 老师服务
 * @author ASUS
 *
 */
@FeignClient("IEP-TEACHER")
public interface TeacherService {
	/**
	 * 获取推荐课程
	 */
	@GetMapping("/course/findCourseById")
	public List<Course> findCourseById(@RequestParam("courId")String courId);

	/**
	 * 报名参加时修改课程报名人数
	 */
	@RequestMapping("/course/updateCourStudypeople")
	public void updateStudypeople(Integer courId);


	/**
	 * 获取老师
	 */
	/*@RequestMapping("/teacher")
	public Result getTeachers(int page,int size);*/


}
