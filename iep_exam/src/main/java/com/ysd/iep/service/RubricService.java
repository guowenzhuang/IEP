package com.ysd.iep.service;

import com.ysd.iep.entity.Rubric;
import org.springframework.data.domain.Page;

public interface RubricService {

    /**
     * 分页查询试题
     *
     * @param page
     * @param size
     * @return
     */
    Page<Rubric> queryUserByuserQuery(Integer page, Integer size);


}
