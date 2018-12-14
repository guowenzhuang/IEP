package com.ysd.iep.service;

import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;

public interface TeachersService {
	//新增老师
    Result insertTeacher(Teachers teachers);
    
    //根据老师id删除老师
    Result deleteTeacherById(String teacherId);
}
