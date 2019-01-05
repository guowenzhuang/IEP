package com.ysd.iep.repository;

import com.ysd.iep.entity.elk.ElkCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElkCourseRepository extends ElasticsearchRepository<ElkCourse,Integer> {

    /**
     *  elasticsearch全局搜索课程分页
     */
    //public Page<ElkCourse> findByCourName(String courName, Pageable pageable);


}
