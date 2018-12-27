package com.ysd.iep.feign;

import com.ysd.iep.entity.CourseDTO;
import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "IEP-TEACHER")
public interface TeacherFeign {
    @GetMapping("/course/queryCourByteaId")
    Result<List<Course>> getCouse(@RequestParam("teaId") String teaId);

    @GetMapping("/course/findCourseById")
    List<CourseDTO> getcoursefrocourseid(@RequestParam("teaId") String courId);


}
