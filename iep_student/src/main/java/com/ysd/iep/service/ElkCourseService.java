package com.ysd.iep.service;

import com.ysd.iep.entity.elk.ElkCourse;
import com.ysd.iep.entity.elk.ElkCourseQuery;
import org.springframework.data.domain.Page;

public interface ElkCourseService {

     Page<ElkCourse> findAllCourseMatchQuery(ElkCourseQuery elkCourseQuery);

}
