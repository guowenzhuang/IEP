package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.DepartmentDB;
import com.ysd.iep.entity.query.DepartmentQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value = "/depart", tags = "院系API")
@RestController
@RequestMapping("/depart")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("查询前七个院系")
    @GetMapping("/getTop7")
    private Result<List<DepartmentDTO>> departTop7() {
        return new Result<List<DepartmentDTO>>(true, departmentService.departmentTop7());
    }

    @ApiOperation("查询全部院系")
    @GetMapping("/get")
    private Result<List<DepartmentDTO>> depart() {
        return new Result<List<DepartmentDTO>>(true, departmentService.department());
    }

    @GetMapping
    public PagingResult<DepartmentDTO> query(DepartmentQuery departmentQuery) {
        return departmentService.query(departmentQuery);
    }

    @PostMapping
    public Result<String> add(@RequestBody DepartmentDB departmentDB){
        departmentService.add(departmentDB);
        return new Result<>(true,"新增成功");
    }

    @PutMapping("/{id}")
    public Result<String> update(@PathVariable("id") String id,@RequestBody DepartmentDB departmentDB){
        departmentDB.setDepartmentId(id);
        departmentService.update(departmentDB);
        return new Result<>(true,"修改成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
        departmentService.delete(id);
        return new Result<>(true,"删除成功");
    }

    @ApiOperation("根据名称查找院系id,多个名称用,号分隔")
    @GetMapping("/getIdByNames")
    public Result<List<String>> getIdByNames(@RequestParam("names") String names){
        List<String> idByNames = departmentService.getIdByNames(names);
        return new Result<List<String>>(true,idByNames);
    }

}
