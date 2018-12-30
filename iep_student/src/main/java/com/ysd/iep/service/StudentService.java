package com.ysd.iep.service;

import com.ysd.iep.entity.Student;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.entity.vo.StudentVo;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.feign.BbsFeign;
import com.ysd.iep.repository.StudentRepository;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired(required = false)
	private AdminFeign adminFeign;
    @Autowired(required = false)
    private BbsFeign bbsFeign;


	/**
	 *     添加学生用户
	 */

	public void addStudent(Student student) {
		studentRepository.save(student);

	}

	/***
	 * 移除学生
	 */

	public void deleteStudent(String sid) {
		studentRepository.deleteById(sid);
	}

	public Result<StudentVo> query(String id){
		Result<List<UsersDTO>> user = adminFeign.get(id);
		UsersDTO usersDTO=user.getMessage().get(0);
		Student student=studentRepository.findById(id).get();
		StudentVo studentVo=new StudentVo();
		BeanConverterUtil.copyObject(usersDTO,studentVo);
		BeanConverterUtil.copyObject(student,studentVo);
		return new Result<StudentVo>(true,studentVo);
	}

	public List<Student> getByIds(String ids){
		String[] idsSplit = ids.split(",");
		List<Student> allById = studentRepository.findBySidIn(idsSplit);
		return allById;
	}


}
