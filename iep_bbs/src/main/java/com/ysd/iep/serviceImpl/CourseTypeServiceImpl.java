package com.ysd.iep.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.CourseTypeRepository;
import com.ysd.iep.entity.CourseType;
import com.ysd.iep.service.CourseTypeService;

@Service
public class CourseTypeServiceImpl implements CourseTypeService{
	@Autowired
	private CourseTypeRepository typeRepository;

	@Override
	public List<CourseType> getAllType() {
		return typeRepository.findAll();
	}

}
