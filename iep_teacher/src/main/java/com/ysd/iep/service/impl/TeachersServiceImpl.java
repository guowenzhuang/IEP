package com.ysd.iep.service.impl;


import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeacherRepository teacherRepository;
    
    //添加
    @Override
    public Result insertTeacher(Teachers teachers) {
        teacherRepository.save(teachers);
        return new Result(true);
    }
    
    //根据老师id删除老师
	@Override
	public Result deleteTeacherById(String teacherId) {
		teacherRepository.deleteById(teacherId);
		 return new Result(true);
		
	}
}
