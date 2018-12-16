package com.ysd.iep.controller;
import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.feign.CourseFeign;
import com.ysd.iep.feign.CurricularFeign;
import com.ysd.iep.service.CourseService;
import com.ysd.iep.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value="/CurricularTaxonomy", tags="课程分类页面")
@RestController
@RequestMapping("/curricularTaxonomy")
public class CurricularTaxonomyController {

    @Autowired
    private CurricularFeign curricularTaxonomyFeign;
    @Autowired
    private CourseService courseService;
    /**
     * 获取全部课程分类
     *http://127.0.0.1:8060/api/student/curricularTaxonomy/getCurricularTaxonomy
     * @return Result
     */

    @ApiOperation(value = "获取全部课程分类")
    @GetMapping("/getCurricularTaxonomy")
    public Result getCurricularTaxonomy(){
        return curricularTaxonomyFeign.getCurricularTaxonomy();
    }

    /**
     * 根据课程分类Id显示课程
     * http://127.0.0.1:8060/api/student/curricularTaxonomy/getCourse
     * @param depId
     * @param page
     * @param size
     * @return Result
     */
    @ApiOperation(value = "根据课程分类Id显示课程")
    @GetMapping("/getCourse")
    public Result getCourse(CourseQuery courseQuery){
        System.out.println("courseQuery==>"+courseQuery);
        return courseService.getCourseAll(courseQuery);
    }
}
