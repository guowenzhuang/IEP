package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherUserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   @GetMapping("/user/getNameById")
   public Result<String> getNameById(@RequestParam("id") String id);
   
   /**
    * 根据用户id获取用户信息
    * @param ids
    * @return
    */
   @GetMapping("/user/getUserById")
   Result<List<TeacherUserDTO>> getUserById(@RequestParam("ids") String ids);
   
   @PutMapping("/user/updateUserById/{id}")
   Result<String> updateUserById(@PathVariable("id") String id,@RequestBody TeacherUserDTO user);



}
