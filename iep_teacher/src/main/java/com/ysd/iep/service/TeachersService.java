package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherDTO;

public interface TeachersService {
	//新增老师
	Integer insertTeacher(String teaId);
    
    //根据老师id删除老师
    Result deleteTeacherById(String teacherId);
    //根据老师id查询
   public List<TeacherDTO> queryTeacher(String teaId);
   
}
