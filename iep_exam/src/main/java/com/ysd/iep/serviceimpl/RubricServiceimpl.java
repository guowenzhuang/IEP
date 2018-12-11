package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.service.RubricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RubricServiceimpl implements RubricService {
    @Autowired
    RubricDao rubricdao;


    @Override
    public Page<Rubric> queryUserByuserQuery(Integer page, Integer size) {
        /*Sort sort = new Sort(Sort.Direction.ASC, "id");*/
        Pageable pageable = new PageRequest(page, size);
        return rubricdao.findAll(pageable);
    }
}
