package com.ysd.iep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.iep.entity.Teachers;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {

}
