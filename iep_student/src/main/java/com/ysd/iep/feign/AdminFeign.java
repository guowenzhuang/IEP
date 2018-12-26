package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-ADMIN")
public interface AdminFeign {
    @GetMapping("/user/getUserById")
    Result<List<UsersDTO>> get(@RequestParam("ids") String ids);
}
