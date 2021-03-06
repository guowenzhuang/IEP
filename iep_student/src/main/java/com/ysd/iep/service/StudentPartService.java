package com.ysd.iep.service;

import com.ysd.iep.entity.StudentPart;
import com.ysd.iep.entity.StudentPartCid;

import java.util.List;

public interface StudentPartService {
	//查询当前学生是否已经报名该课程
	public List<StudentPartCid> queryStudentPart(String sid);
	
	//报名此课程的人数
	public int count(Integer cid);
	
    //添加学生课程报名信息
	//@PreAuthorize("hasAuthority('studentPart:addstudentPart')")
	public void add(Integer courId, String sid);
	
	//删除学生课程报名信息
	public void delete(StudentPart studentPart);

	public List<StudentPart> findByCid(Integer cid);
	
}
