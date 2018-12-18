package com.ysd.iep.controller;

import com.ysd.iep.entity.dto.RecommendIndexDTO;
import com.ysd.iep.entity.po.Recommend;
import com.ysd.iep.service.PositionService;
import com.ysd.iep.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Recommend> getRecomment(@RequestParam("code") String code){
        String positionId=positionService.get(code);
        return recommendService.get(positionId);
    }

    @ApiOperation("获取首页推荐")
    @GetMapping("/index")
    public RecommendIndexDTO getRecommentIndex(){
        String positionId001=positionService.get("001");
        List<Recommend> recommends001=recommendService.get(positionId001);
        String positionId002=positionService.get("002");
        List<Recommend> recommends002=recommendService.get(positionId002);
        RecommendIndexDTO recommendIndexDTO=new RecommendIndexDTO();
        recommendIndexDTO.setRecommend001(recommends001);
        recommendIndexDTO.setRecommend002(recommends002);
        return recommendIndexDTO;
    }

}
