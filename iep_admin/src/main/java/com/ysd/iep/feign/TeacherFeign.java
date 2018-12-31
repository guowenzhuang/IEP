package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherAddDTO;
import com.ysd.iep.entity.dto.UsersTeaDTO;
import com.ysd.iep.entity.vo.PagingResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-TEACHER")
public interface TeacherFeign {

    @GetMapping("/tea")
    Result<List<UsersTeaDTO>> get(@RequestParam("teaid") String teaids);
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
    @GetMapping("/course/queryDTO")
    PagingResult<CourseDTO> getPaginate(@RequestParam Map<String, Object> map);

    /**
     * 新增老师
     * @param tepId
     * @return
     */
    @PostMapping("/tea/addTeacher")
    Result<String> AddTeacher(@RequestParam("teaId")String tepId);

    /**
     * 删除老师
     * @param teacherId
     * @return
     */
    @DeleteMapping("/tea/deleteTeacherById")
    Result<String> deleteTeacherById(@RequestParam("teacherId") String teacherId);
    
    @PostMapping("/tea/addTeachers")
    public Result<String> addTeacher(@RequestBody TeacherAddDTO tea);
}
