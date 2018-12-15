package com.ysd.iep.service;

import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class CourseService {
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    public PagingResult<CourseDTO> query(CourseQuery courseQuery){
        System.out.println("courseQuery==>"+courseQuery);
        Map map= BeanConverterUtil.objectToMap(courseQuery);
        Page<CourseDTO> paginate = teacherFeign.getPaginate(map);
        return new PagingResult<CourseDTO>().setTotal(paginate.getTotalElements()).setRows(paginate.getContent());
    }
}
