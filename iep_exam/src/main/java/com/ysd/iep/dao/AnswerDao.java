package com.ysd.iep.dao;

import com.ysd.iep.entity.Answer;
import com.ysd.iep.entity.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author gaozhognye
 * @date 2018/12/7
 * 选项dao
 */

public interface AnswerDao extends JpaRepository<Answer, String>, JpaSpecificationExecutor<Answer> {

}
