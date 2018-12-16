package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("IEP-TEACHER")
public interface CourseFeign {
    /**
     * 课程的分页查询
     * @param depId
     * @param page
     * @param size
     * @return
     */
    @GetMapping ("/course/getCourUIPage")
    Result getCourseAll(@RequestParam Map<String, Object> map);
}
