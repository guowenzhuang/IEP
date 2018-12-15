package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.ModulesDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.vo.ModuleTreeVo;
import com.ysd.iep.service.ModulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/module", tags="模块API")
@RestController
@RequestMapping("/module")
public class ModulesController {
    @Autowired
    private ModulesService modulesService;
    /**
     *获取老师的菜单
     * @return
     */
    @ApiOperation(value = "获取老师菜单",notes="根据老师角色获取老师的菜单")
    @GetMapping("/getMenuByTearch")
    public Result<List<ModulesDTO>> getMenuByTearch(){
        List<ModulesDTO> list=modulesService.getByRole("老师");
        return new Result<List<ModulesDTO>>(true).setMessage(list);
    }

    @GetMapping("/getMenuByRole")
    public Result<List<ModulesDTO>> getMenuByRole(String rolenames){
        List<ModulesDTO> list=modulesService.getByRole(rolenames.split(","));
        return new Result<List<ModulesDTO>>(true).setMessage(list);
    }
    @GetMapping("/getAllCheckRole")
    public ModuleTreeVo getAllCheckRole(String roleid){
        return modulesService.getAllCheckRole(roleid);
    }
}
