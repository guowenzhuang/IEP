package com.ysd.iep.dao;

import com.ysd.iep.entity.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 题干表dao
 */

public interface RubricDao extends JpaRepository<Rubric, String>, JpaSpecificationExecutor<Rubric> {
    /***
     * 根据课程Id查询题库
     * @param courseId
     * @return
     */
    List<Rubric> findByCourseId(Integer courseId);



}
