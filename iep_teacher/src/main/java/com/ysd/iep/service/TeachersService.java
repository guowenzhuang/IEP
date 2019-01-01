package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherUserDTO;

public interface TeachersService {
	
	//新增老师
	Integer insertTeacher(String teaId);
    
    //根据老师id删除老师
    Result deleteTeacherById(String teacherId);
  //根据Id查询用户信息 
    List<TeacherUserDTO> getTeaUser();
   
   /**
     * 根据教师id查询教师信息
    * @param id
    * @return
    */
    List<TeacherUserDTO> queryTeaUserById(String id);
   
    void updateTeacher(TeacherUserDTO teauser);

    List<String> getTeaIdByDepartmentId(String departMentId);
   
   //新增老师
  	void addteacher(Teachers tea);
}
