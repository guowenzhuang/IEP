package com.ysd.iep.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ysd.iep.tools.Result;

@FeignClient("IEP-STUDENT")
public interface StudentFeign {
	
	@GetMapping("/study/getphotoByIds")
	String getphotoByIds(@RequestParam("id") String id);

}
