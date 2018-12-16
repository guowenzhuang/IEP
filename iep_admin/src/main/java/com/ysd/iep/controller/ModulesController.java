package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.AddModulesDTO;
import com.ysd.iep.entity.dto.ModulesDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.ModulesDB;
import com.ysd.iep.entity.vo.ModuleCascaderVo;
import com.ysd.iep.entity.vo.ModuleTreeVo;
import com.ysd.iep.service.ModulesService;
import com.ysd.iep.util.BeanConverterUtil;
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

    @GetMapping
    public List<ModulesDTO> get(){
        return modulesService.getAll();
    }

    @GetMapping("/getToCascader")
    public List<ModuleCascaderVo> getToCascader(){
        return modulesService.getAllToCascader();
    }

    @PostMapping
    public Result add(AddModulesDTO addModulesDTO){
        modulesService.add((ModulesDB) BeanConverterUtil.copyObject(addModulesDTO,ModulesDB.class));
        return new Result(true,"新增成功");
    }

    @PutMapping
    public Result update(AddModulesDTO addModulesDTO){
        modulesService.update((ModulesDB) BeanConverterUtil.copyObject(addModulesDTO,ModulesDB.class));
        return new Result(true,"修改成功");
    }

    @GetMapping("/getParentId/{mid}")
    public List<Integer> get(@PathVariable("mid") Integer mid){
        return modulesService.get(mid);
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable("id") Integer id){
        modulesService.del(id);
        return new Result(true,"删除成功");
    }
}
