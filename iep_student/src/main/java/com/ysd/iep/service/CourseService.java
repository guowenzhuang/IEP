package com.ysd.iep.service;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.feign.CourseFeign;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
public class CourseService {
    @Autowired(required = false)
    private CourseFeign courseFeign;

    public Result getCourseAll(CourseQuery courseQuery){
        System.out.println("courseQuery==>"+courseQuery);
        Map map= BeanConverterUtil.objectToMap(courseQuery);
        return courseFeign.getCourseAll(map);
    }
}
