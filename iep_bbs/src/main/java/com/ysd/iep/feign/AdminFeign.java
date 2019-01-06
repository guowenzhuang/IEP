package com.ysd.iep.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ysd.iep.tools.Result;

import java.util.List;


@FeignClient("IEP-ADMIN")
public interface AdminFeign {
	
	@GetMapping("/user/getNameById")
    Result getNameById(@RequestParam("id") String id);

	@GetMapping("/user/getNameByIds")
    Result<List<String>> getNameByIds(@RequestParam("ids") String ids);

}
