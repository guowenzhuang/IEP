package com.ysd.iep.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 调管理员服务
 * @author ASUS
 *
 */
@FeignClient("IEP-ADMIN")
public interface AdminService {
	/**
	 * 获取分类
	 * @return
	 */
	@RequestMapping("/depart/getTop7")
	public Object getCategory();
	
	/**
	 *获取课程推荐
	 */
	
	

}
