package com.ysd.iep.service.serviceImpl;

import com.ysd.iep.entity.elk.ElkCourse;
import com.ysd.iep.entity.elk.ElkCourseQuery;
import com.ysd.iep.repository.ElkCourseRepository;
import com.ysd.iep.service.ElkCourseService;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ElkCourseServiceImpl implements ElkCourseService {
    @Autowired
    private ElkCourseRepository elkCourseRepository;

    @Override
    public Page<ElkCourse> findAllCourseMatchQuery(ElkCourseQuery elkCourseQuery){
        Sort sort =null;
            if(elkCourseQuery.getOrderby().equalsIgnoreCase("asc")){
                sort= new Sort(Sort.Direction.ASC, elkCourseQuery.getConditions());
            }else{
                sort= new Sort(Sort.Direction.DESC, elkCourseQuery.getConditions());
            }

        Pageable pageable = PageRequest.of(elkCourseQuery.getPage()-1, elkCourseQuery.getSize(), sort);
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(elkCourseQuery.getValue(), "cour_name", "cour_content", "cour_details");
        Page<ElkCourse> search = elkCourseRepository.search(multiMatchQueryBuilder,pageable);
        return search;
    }
}
