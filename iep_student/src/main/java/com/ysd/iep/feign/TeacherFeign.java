package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.Chapters;
import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("IEP-TEACHER")
public interface TeacherFeign {
    /**
     *  根据课程id查询课程 多个id用,号分割
    * @param courId
    * @return
    */

    @RequestMapping("/course/findCourseById")
    List<Course> getCoursedetails(@RequestParam("courId") String courId);

    @GetMapping("/chapter/queryChapter")
    List<Chapters> queryChapter(@RequestParam("courId") Integer courId);
}
