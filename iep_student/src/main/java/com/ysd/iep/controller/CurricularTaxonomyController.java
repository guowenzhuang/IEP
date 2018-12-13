package com.ysd.iep.controller;
import com.ysd.iep.util.Result;
import com.ysd.iep.service.CurricularTaxonomyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value="/CurricularTaxonomy", tags="课程分类页面")
@RestController
@RequestMapping("/curricularTaxonomy")
public class CurricularTaxonomyController {

    @Autowired
    private CurricularTaxonomyService curricularTaxonomyService;
    /**
     * 获取全部课程分类
     *http://127.0.0.1:8060/api/student/curricularTaxonomy/getCurricularTaxonomy
     * @return Result
     */

   @ApiOperation(value = "获取全部课程分类")
    @GetMapping("/getCurricularTaxonomy")
    public Result getCurricularTaxonomy(){
        return curricularTaxonomyService.getCurricularTaxonomy();
    }
    public void getCourse(){
      //zx
    }
}
