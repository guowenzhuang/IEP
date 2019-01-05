package com.ysd.iep.service;

import com.ysd.iep.entity.elk.ElkCourse;
import org.springframework.data.domain.Page;

public interface ElkCourseService {

     Page<ElkCourse> findAllCourseMatchQuery(String value, Integer page, Integer size);

}
