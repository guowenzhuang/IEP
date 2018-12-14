package com.ysd.iep.service;

import com.ysd.iep.entity.Course;
import com.ysd.iep.entity.dto.Result;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CourseService {
    /**
     * 课程的分页查询
     * @param page
     * @param pageSize
     * @param courName
     * @return
     */
    Page<Course> getPaginate(int page, int pageSize, String courName);

    /**
     * 删除课程
     * @param courId 课程id
     */
     void deleteById(Integer courId);

     /**
      * 课程的分页查询(前台)
      * @param depId
      * @param page
      * @param   size
      * @return  Page<Course>
      */
     public Page<Course> queryCourseDepidAllPage(@RequestParam("depId")String depId,@RequestParam("page")Integer page, @RequestParam("size")Integer size);


    /**
     * 新增课程
     * @param course
     * @return
     */
    Result insertCourse(Course course);

    /**
     * 提供  根据课程id查询课程信息
     * @param courId
     * @return
     */

    List<Course> findByCourseId(Integer courId);

}
