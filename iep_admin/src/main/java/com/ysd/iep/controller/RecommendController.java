package com.ysd.iep.controller;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ysd.iep.entity.dto.RecommendIndexDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.PositionDB;
import com.ysd.iep.entity.po.RecommendDB;
import com.ysd.iep.service.PositionService;
import com.ysd.iep.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/recommend", tags="推荐API")
@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private RecommendService recommendService;

    @ApiOperation("根据代码获取课程id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "代码",required = true,paramType = "query",dataType = "String")
    })
    @GetMapping
    public List<RecommendDB> getRecomment(@RequestParam("code") String code){
        PositionDB positionDB=positionService.get(code);
        return recommendService.get(positionDB);
    }

    @ApiOperation("获取首页推荐")
    @GetMapping("/index")
    public RecommendIndexDTO getRecommentIndex(){
        PositionDB positionId001=positionService.get("001");
        List<RecommendDB> recommends001=recommendService.get(positionId001);
        PositionDB positionId002=positionService.get("002");
        List<RecommendDB> recommends002=recommendService.get(positionId002);
        RecommendIndexDTO recommendIndexDTO=new RecommendIndexDTO();
        recommendIndexDTO.setRecommend001(recommends001);
        recommendIndexDTO.setRecommend002(recommends002);
        return recommendIndexDTO;
    }

    @PostMapping
    public Result<String> add(@RequestBody RecommendDB recommendDB){
        try {
            recommendService.add(recommendDB);
        } catch (Exception e) {
          return new Result<String>(false,"推荐失败,已经推荐过此位置");
        }
        return new Result<String>(true,"推荐成功");
    }

    @DeleteMapping
    public Result<String> delAll(String coursetId,String positionIds){
        recommendService.delAll(coursetId, positionIds);
        return new Result<String>(true,"删除成功");
    }

}
