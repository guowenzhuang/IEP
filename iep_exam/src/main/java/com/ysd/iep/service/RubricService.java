package com.ysd.iep.service;

import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.RubricQuery;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RubricService {

    /**
     * 分页查询试题
     *
     * @return
     */
    List<Rubric> queryUserByuserQuery(RubricQuery rubricquery);

 /*   public List<Rubric> queryByDynamicSQL(RubricQuery rubricquery);*/






}
