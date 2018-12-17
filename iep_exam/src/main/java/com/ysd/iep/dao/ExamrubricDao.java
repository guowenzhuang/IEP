package com.ysd.iep.dao;

import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ExamrubricDao extends JpaRepository<Examrubric, String> {

}
