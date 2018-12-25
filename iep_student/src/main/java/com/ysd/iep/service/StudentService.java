package com.ysd.iep.service;

import com.ysd.iep.entity.Student;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.util.Result;
import org.springframework.web.bind.annotation.RequestParam;

public interface StudentService {
	
	public void addStudent(Student student);
	
	public void deleteStudent(String sid);

}
