package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.CourseType;
import com.ysd.iep.entity.Typetb;

public interface CourseTypeService {
	/**
	 * 获取所有帖子分类对象
	 * @return
	 */
	public List<CourseType> getAllType();

}
