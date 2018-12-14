package com.ysd.iep.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.entity.StudentPart;
import com.ysd.iep.repository.StudentPartRepository;
import com.ysd.iep.service.StudentPartService;

@Service
public class StudentPartServiceImpl implements StudentPartService {
	
	@Autowired
	private StudentPartRepository partRepository;
	
	//查询当前学生是否已经报名该课程
	public List<Integer> queryStudentPart(String sid) {
		
		return partRepository.findBySid(sid);
	}

	// 添加学生课程报名信息
	public void add(Integer courId, String sid) {
		StudentPart stu = new StudentPart();
		Date date = new Date();
		stu.setParttime(date);
		stu.setCid(courId);
		stu.setSid(sid);
		partRepository.save(stu);
	}

	// 删除学生课程报名信息
	public void delete(StudentPart studentPart) {
         
	};

}
