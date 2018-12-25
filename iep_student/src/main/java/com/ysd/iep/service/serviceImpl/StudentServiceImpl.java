package com.ysd.iep.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.entity.Student;
import com.ysd.iep.repository.StudentRepository;
import com.ysd.iep.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
    /**
           *     添加学生用户
     */
	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}
	
	/***
	 * 移除学生
	 */
	@Override
	public void deleteStudent(String sid) {
		studentRepository.deleteById(sid);
	}

}
