package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/depart", tags="院系API")
@RestController
@RequestMapping("/depart")
public class DepartMentController {
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("查询前七个院系")
    @GetMapping("/get")
    private Result<List<DepartmentDTO>> depart(){
        return new Result<List<DepartmentDTO>>(true,departmentService.department());
    }
}
