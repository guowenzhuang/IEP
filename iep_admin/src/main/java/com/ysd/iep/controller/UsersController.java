package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.entity.query.UsersQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.UsersVo;
import com.ysd.iep.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/user", tags="用户API")
@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @ApiOperation("根据用户姓名获取用户的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户姓名",required = true,paramType = "query",dataType = "String")
    })
    @GetMapping
    private Result<UsersDTO> user(@RequestParam("name") String name){
        return new Result<UsersDTO>(true,usersService.userByName(name));
    }

    @GetMapping(value="query")
    public PagingResult<UsersVo> query(UsersQuery usersQuery){
        return usersService.query(usersQuery);
    }
}
