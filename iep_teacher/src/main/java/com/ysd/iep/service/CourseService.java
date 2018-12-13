package com.ysd.iep.service;

import com.ysd.iep.entity.Course;
import com.ysd.iep.entity.dto.Result;
import org.springframework.data.domain.Page;

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
     * 新增课程
     * @param course
     * @return
     */
    Result insertCourse(Course course);

    /**
     * 修改课程
     * @param course
     * @return
     */
    Result updateCourse(Course course);
}
