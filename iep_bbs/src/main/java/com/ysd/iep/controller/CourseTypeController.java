package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.CourseType;
import com.ysd.iep.service.CourseTypeService;

@RestController
@RequestMapping(value = "coursetype")
public class CourseTypeController {
	@Autowired
	private CourseTypeService typeService;
	/**
	 *   获取全部分类
	 * @return
	 */
	@RequestMapping(value="getAllType")
	public Object getAllType() {
		List<CourseType> typeList=typeService.getAllType();
		return typeList;		
	}

}
