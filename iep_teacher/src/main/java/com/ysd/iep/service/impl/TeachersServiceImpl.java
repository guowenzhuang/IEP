package com.ysd.iep.service.impl;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Teachers;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.TeacherUserDTO;
import com.ysd.iep.feign.AdminFeign;
import com.ysd.iep.service.TeachersService;
import com.ysd.iep.util.BeanConverterUtil;

import javax.transaction.Transactional;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private AdminFeign adminFeign;
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

	/**
	 * 查询所有教师信息
	 */
	@Override
	public List<TeacherUserDTO> getTeaUser() {
		List<String> idd=teacherRepository.queryTeacherId();
		//String ids = Joiner.on(",").join(idd);
		List<Teachers> tea = teacherRepository.findAllById(idd);
		System.out.println("wwwwwwwwwwwww>>>"+tea);
		Result<List<TeacherUserDTO>> result =adminFeign.getUserById(Joiner.on(",").join(idd));
		List<TeacherUserDTO> teauser=result.getMessage();
		for (int i = 0; i < teauser.size(); i++) {
			TeacherUserDTO tu=teauser.get(i);
            Teachers u=tea.get(i);
            BeanConverterUtil.copyObject(u,tu);
        }
		return teauser;
	}

	/**
	    * 根据教师id查询教师信息
	    * @param id
	    * @return
	    */
	@Override
	public List<TeacherUserDTO> queryTeaUserById(String id) {
		Teachers tea = teacherRepository.findByTeaId(id);
		Result<List<TeacherUserDTO>> result =adminFeign.getUserById(id);
		List<TeacherUserDTO> teacheruer = result.getMessage();
		for (int i = 0; i < teacheruer.size(); i++) {
			TeacherUserDTO tu=teacheruer.get(i);
            BeanConverterUtil.copyObject(tea,tu);
        }
		return teacheruer;
	}

	/**
	 * 修改教师信息
	 */
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void updateTeacher(TeacherUserDTO teauser) {
		Teachers t = (Teachers) BeanConverterUtil.copyObject(teauser, Teachers.class);
		t.setTeaId(teauser.getId());
		teacherRepository.save(t);
		//teacherRepository.updateTeacher(teauser.getTeaDescribe(), teauser.getTeaTalk(),teauser.getTeaSex(),teauser.getId());
	}

	@Override
	public List<String> getTeaIdByDepartmentId(String departMentId){
		return teacherRepository.getByTeaDepartmentid(departMentId).stream().map(Teachers::getTeaId).collect(Collectors.toList());
	}

	@Override
	public void addteacher(Teachers tea) {
		teacherRepository.save(tea);
	}
}
