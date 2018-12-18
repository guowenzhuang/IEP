package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.entity.dto.UsersUpdateDTO;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.query.UsersQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.UsersVo;
import com.ysd.iep.feign.StudentFeign;
import com.ysd.iep.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("根据用户id获取用户的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "用户id 多个id用,号分割",required = true,paramType = "query",dataType = "String")
    })
    @GetMapping("/getUserById")
    public Result<List<UsersDTO>> getUserById(@RequestParam("ids") String ids){
        return new Result<List<UsersDTO>>(true,usersService.userById(ids));
    }

    @PostMapping
    public Result<String> add(@RequestBody UsersDB usersDB){
        usersService.add(usersDB);
        return new Result<String>(true,"成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
        usersService.delete(id);
        return new Result<String>(true).setMessage("成功");
    }

    @PutMapping
    public Result<String> update(@RequestBody UsersUpdateDTO usersUpdateDTO){
        usersService.update(usersUpdateDTO);
        return new Result<String>(true).setMessage("成功");
    }


    @GetMapping(value="query")
    public PagingResult<UsersVo> query(UsersQuery usersQuery){
        return usersService.query(usersQuery);
    }

    @PutMapping("/updateUserField/{uuid}")
    public Result updateUserField(@PathVariable("uuid") String uuid,String fieldName,String fieldValue){
        return usersService.updateUserField(uuid,fieldName,fieldValue);
    }

    @PostMapping("/setRole/{uuid}")
    public Result<String> setRole(@PathVariable("uuid") String uuid,String roleIds,String direction){
        usersService.setRoles(uuid, roleIds, direction);
        return new Result<String>(true);
    }

}
