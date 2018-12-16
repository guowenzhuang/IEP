package com.ysd.iep.service;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 老师服务
 * @author ASUS
 *
 */
@FeignClient("IEP-TEACHER")
public interface TeacherService {

	/**
	 * 获取老师
	 */
	/*@RequestMapping("/teacher")
	public Result getTeachers(int page,int size);*/


}
