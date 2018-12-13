package com.ysd.iep.feign;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("IEP-TEACHER")
public interface CourseFeign {
    @RequestMapping("/course/getCourUIPage")
    Result getCourseAll(String depId,Integer page, Integer size);
}
