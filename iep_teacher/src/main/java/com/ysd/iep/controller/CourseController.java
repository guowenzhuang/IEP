package com.ysd.iep.controller;

import com.ysd.iep.entity.Course;
import com.ysd.iep.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
   private CourseService courseService;

    /**
     *
     * @param page
     * @param pageSize
     * @param courName
     * @return
     */
    @RequestMapping("/getPaginate")
    public Page<Course> getPaginate(int page, int pageSize, String courName){

        return courseService.getPaginate(page, pageSize, courName);

    }
}
