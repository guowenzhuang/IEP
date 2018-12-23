package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.Result;

import com.ysd.iep.entity.dto.UsersDTO;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 *
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient(value = "IEP-ADMIN")
public interface AdminFeign {
    /**
     * 获取老师菜单
     * @return
     */
    @GetMapping("/module/getMenuByTearch")
    Result getMenu();
    /**
     * 获取用户信息(教师name)
     * @param ids
     * @return
     */
   @GetMapping("/user/getUserById")
    Result<List<UsersDTO>> getUserById(@RequestParam("ids") String ids);

}
