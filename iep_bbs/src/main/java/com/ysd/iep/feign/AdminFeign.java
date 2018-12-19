package com.ysd.iep.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysd.iep.tools.Result;


@FeignClient("IEP-ADMIN")
public interface AdminFeign {
	@RequestMapping("/user/getUserById")
    Result getUserById();

}
