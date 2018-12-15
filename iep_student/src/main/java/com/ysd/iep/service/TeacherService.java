package com.ysd.iep.service;

import org.springframework.cloud.openfeign.FeignClient;
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
	
	

}
