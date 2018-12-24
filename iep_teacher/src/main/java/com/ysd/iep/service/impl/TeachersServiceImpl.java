package com.ysd.iep.service.impl;


import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherDTO;
import com.ysd.iep.service.TeachersService;
import com.ysd.iep.util.JpaObjectsToEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeacherRepository teacherRepository;
    
    //添加
    @Override
    public Integer insertTeacher(String teaId){
    	 
		return teacherRepository.addTecherById(teaId);
		
        
    }
    
    //根据老师id删除老师
	@Override
	public Result deleteTeacherById(String teacherId) {
		if (teacherId != null && teacherId != "") {
			teacherRepository.deleteById(teacherId);
		}
		 return new Result(true);
	}

	@Override
	public List<TeacherDTO> queryTeacher(String teaId) {
		List<Object[]>  objectsList = teacherRepository.queryTeacher(teaId);
		System.out.println("aaaaaaaaa>>>>>>>."+objectsList);
		List<TeacherDTO> list = (List<TeacherDTO>) JpaObjectsToEntity.jpaResultToObjectList(objectsList,TeacherDTO.class); 
		System.out.println("cccccccccccccccc>>>>>>>."+list);
		return list;
	}
	

}
