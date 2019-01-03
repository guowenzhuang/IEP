package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.vo.PermissionTreeVo;
import com.ysd.iep.entity.vo.PermissionVo;
import com.ysd.iep.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/permission", tags="权限API")
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/collectPermission")
    public Result collectPermission(){
        return permissionService.collectPermission();
    }

    @GetMapping
    public List<PermissionVo> get(){
        return permissionService.get();
    }

    @GetMapping("/{roleId}")
    public PermissionTreeVo get(@PathVariable("roleId") String roleId){
        List<String> pids=permissionService.get(roleId);
        List<PermissionVo> permissionVos=permissionService.get();
        PermissionTreeVo permissionTreeVo=new PermissionTreeVo();
        permissionTreeVo.setPids(pids);
        permissionTreeVo.setPermissions(permissionVos);
        return permissionTreeVo;
    }

    @GetMapping("/judgePermission")
    public Result judgePermission(Authentication user,String value){
        return permissionService.judgePermission(user.getAuthorities(),value);
    }
}
