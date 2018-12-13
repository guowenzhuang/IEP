package com.ysd.iep.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysd.iep.util.Result;
/**
 * 调管理员服务
 * @author ASUS
 *
 */
@FeignClient("IEP-ADMIN")
public interface AdminService {
	
	/**
	 * 获取课程分类
	 * @return
	 */
	@RequestMapping("/depart/getTop7")
	public Result getCategory();
	
	/**
	 * 获取推荐课程
	 */
	

}
