package com.ysd.iep.feign;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "IEP-ADMIN")
public interface AdminFrign {

    @GetMapping("/user/getNameById")
    Result getNameById(@RequestParam("id") String id);

}
