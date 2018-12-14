package com.ysd.iep.service;

import com.ysd.iep.entity.StudentPart;

/*
 * 
 */

public interface StudentPartService {
	
	
    //添加学生课程报名信息
	public void add(Integer courId, String sid); 
	
	//删除学生课程报名信息
	public void delete(StudentPart studentPart);
	
}
