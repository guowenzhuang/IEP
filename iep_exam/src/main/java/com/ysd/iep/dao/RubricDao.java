package com.ysd.iep.dao;

import com.ysd.iep.entity.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 题干表dao
 */

public interface RubricDao extends JpaRepository<Rubric, String> {
}
