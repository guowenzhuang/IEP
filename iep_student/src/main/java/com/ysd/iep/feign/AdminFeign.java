package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.StudentUserDTO;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/user/getNameById")
    Result getNameById(@RequestParam("id") String id);

    /**
     * 根据用户id获取用户信息
     * @param ids
     * @return
     */
    @GetMapping("/user/getUserById")
    Result<List<StudentUserDTO>> getUserById(@RequestParam("ids") String ids);
    
    @PutMapping("/user/updateUserById/{id}")
    Result<String> updateUserById(@PathVariable("id") String id,@RequestBody StudentUserDTO user);
}
