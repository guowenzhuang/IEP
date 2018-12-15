package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherDTO;
import com.ysd.iep.entity.query.CourseQuery;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-TEACHER")
public interface TeacherFeign {
    /**
     * 根据课程id查询课程
     *
     * @param courId
     * @return
     */
    @GetMapping("/course/queryCourByteaId")
    List<CourseDTO> findCourseById(@RequestParam("courId") String courId);

    /**
     * 课程分页
     *
     * @return
     */
    @GetMapping("/course/getPaginate")
    Page<CourseDTO> getPaginate(@RequestParam Map<String, Object> map);

    /**
     * 新增老师
     * @param teacherDTO
     * @return
     */
    @PostMapping("/tea/addTeacher")
    Result<String> AddTeacher(TeacherDTO teacherDTO);

    /**
     * 删除老师
     * @param teacherId
     * @return
     */
    @DeleteMapping("/tea/deleteTeacherById")
    Result<String> deleteTeacherById(@RequestParam("teacherId") String teacherId);
}
