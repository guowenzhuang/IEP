package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Teachers;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends JpaRepository<Teachers, String> , JpaSpecificationExecutor<Teachers> {

}
