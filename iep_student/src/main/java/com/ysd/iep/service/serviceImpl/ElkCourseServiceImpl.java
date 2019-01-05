package com.ysd.iep.service.serviceImpl;

import com.ysd.iep.entity.elk.ElkCourse;
import com.ysd.iep.repository.ElkCourseRepository;
import com.ysd.iep.service.ElkCourseService;
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
    public Page<ElkCourse> findAllCourseMatchQuery(String value, Integer page, Integer size){

        Sort sort = new Sort(Sort.Direction.DESC, "courStudypeople");
        Pageable pageable = PageRequest.of(page-1, size, sort);

        //elkCourseRepository.search(QueryBuilders.matchQuery(courName,courName),pageable);

        return elkCourseRepository.search(QueryBuilders.multiMatchQuery(value,"cour_name","cour_content","cour_details"),pageable);
    }
}
