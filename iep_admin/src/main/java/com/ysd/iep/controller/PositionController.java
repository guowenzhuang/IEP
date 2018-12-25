package com.ysd.iep.controller;

import com.ysd.iep.entity.po.PermissionDB;
import com.ysd.iep.entity.po.PositionDB;
import com.ysd.iep.service.PositionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value = "/position", tags = "推荐位置API")
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<PositionDB> query(){
        return positionService.get();
    }

    @GetMapping("/getname/{courId}")
    public List<Map> get(@PathVariable("courId") Integer courId){
        return positionService.get(courId);
    }
}
