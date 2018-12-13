package com.ysd.iep.feign;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("IEP-TEACHER")
public interface CourseFeign {

    @RequestMapping("/course/getCourUIPage")
    Result getCourseAll(@RequestParam("depId")String depId, @RequestParam("page")Integer page, @RequestParam("size")Integer size);
}
