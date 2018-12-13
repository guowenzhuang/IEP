package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.vo.UserRoleVo;
import com.ysd.iep.service.DepartmentService;
import com.ysd.iep.service.RolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/role", tags="角色API")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("/getRole/{uuid}")
    public Result<UserRoleVo> queryUnAndNoqueryUn(@PathVariable("uuid") String uuid){
        UserRoleVo userRoleVo= rolesService.queryUnAndNoqueryUn(uuid);
        return new Result<UserRoleVo>(true, userRoleVo);
    }


}
