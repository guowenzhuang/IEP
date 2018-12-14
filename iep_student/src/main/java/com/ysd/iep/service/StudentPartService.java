package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.StudentPart;

public interface StudentPartService {
	//查询当前学生是否已经报名该课程
	public List<Integer> queryStudentPart(String sid);
	
    //添加学生课程报名信息
	public void add(Integer courId, String sid); 
	
	//删除学生课程报名信息
	public void delete(StudentPart studentPart);
	
}
