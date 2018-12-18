package com.ysd.iep.service;

import com.ysd.iep.entity.dto.RecommendIndexDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
	 *获取课程推荐id
	 */
	@RequestMapping("/recommend/index")
	public RecommendIndexDTO getRecommentIndex();
	

}
