package com.ysd.iep.service;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@PermissionType("课程")
public class CourseService {
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    @PreAuthorize("hasAuthority('cource:query')")
    @PermissionMethod("课程查询")
    public PagingResult<CourseDTO> query(CourseQuery courseQuery){
        System.out.println("courseQuery==>"+courseQuery);
        Map map= BeanConverterUtil.objectToMap(courseQuery);
        return teacherFeign.getPaginate(map);
    }
}
