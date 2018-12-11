package com.ysd.iep.controller;
import com.ysd.iep.util.Result;
import com.ysd.iep.service.CurricularTaxonomyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value="/CurricularTaxonomy", tags="课程分类页面")
@RestController
@RequestMapping("/curricularTaxonomy")
public class CurricularTaxonomyController {

    @Autowired
    private CurricularTaxonomyService curricularTaxonomyService;
    /**
     * http://localhost:8001/getProviderFuture
     * http://localhost:8002/getFuture
     * @return
     */

   @ApiOperation(value = "获取全部课程分类")
    @RequestMapping("/getCurricularTaxonomy")
    public Result getCurricularTaxonomy(){
        return curricularTaxonomyService.getCurricularTaxonomy();
    }
}
