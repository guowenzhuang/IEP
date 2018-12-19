package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.query.RolesQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.RolesVo;
import com.ysd.iep.entity.vo.UserRoleVo;
import com.ysd.iep.service.DepartmentService;
import com.ysd.iep.service.RolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping
    public PagingResult<RolesVo> role(RolesQuery rolesQuery){
        return rolesService.queryRolesPaging(rolesQuery);
    }

    @PostMapping
    public Result add(@RequestParam("name") String name){
        rolesService.add(name);
        return new Result(true);
    }

    @PostMapping("/setModule/{roleiId}")
    public Result<String> setModule(@PathVariable("roleiId") String roleiId,@RequestParam("mids") String mids){
        rolesService.setModule(roleiId,mids);
        return new Result(true,"成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
        rolesService.delete(id);
        return new Result<String>(true).setMessage("成功");
    }

    @PostMapping("/setPermission/{roleiId}")
    public Result<String> setPermission(@PathVariable("roleiId") String roleiId,@RequestParam("pids") String pids){
        rolesService.setPermission(roleiId,pids);
        return new Result(true,"成功");
    }

}
