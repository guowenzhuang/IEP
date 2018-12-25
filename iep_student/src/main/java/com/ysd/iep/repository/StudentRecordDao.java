package com.ysd.iep.repository;

import com.ysd.iep.entity.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 学生学习接口
 */
public interface StudentRecordDao extends JpaRepository<StudentRecord ,Integer> {

}
