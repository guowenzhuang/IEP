package com.ysd.iep.feign;

import com.ysd.iep.entity.CourseDTO;
import com.ysd.iep.entity.parameter.Chapters;
import com.ysd.iep.util.Result;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "IEP-TEACHER")
public interface TeacherFeign {

    @GetMapping("/course/queryCourByteaId")
    Result<List<Course>> getCouse(@RequestParam("teaId") String teaId);

    /**
     * 根据教师id获取教师所有的课程
     * @param courId
     * @return
     */
    @GetMapping("/course/findCourseById")
    List<CourseDTO> getcoursefrocourseid(@RequestParam("teaId") String courId);

    /**
     * 根据课程id获取课程详情
     *
     * @param courid
     * @return
     */
    @GetMapping("/course/queryCourByid")
    Result<Course> queryCourByid(@RequestParam("courid") Integer courid);

    /**
     * 根据课程id查询父章节
     */
    @GetMapping("/chapter/queryParentChapter")
    Result<List<Chapters>> queryParentChapter(@RequestParam("courId") Integer courId);


}
