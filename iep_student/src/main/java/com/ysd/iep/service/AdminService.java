package com.ysd.iep.service;

import com.ysd.iep.entity.dto.RecommendIndexDTO;
import com.ysd.iep.util.PagingResult;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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
	@GetMapping("/recommend/index")
	public RecommendIndexDTO getRecommentIndex();

	/**
	 * 分页查询教师
	 * @param map
	 * @return
	 */
	@GetMapping("/user/getByRole")
	public PagingResult getTeachers(@RequestParam Map<String, Object> map);

	/**
	 * 根据类别名称获取类别id
	 */
	@GetMapping("/depart/getIdByNames")
	public Result getIdByNames(@RequestParam("names")String names);

}
