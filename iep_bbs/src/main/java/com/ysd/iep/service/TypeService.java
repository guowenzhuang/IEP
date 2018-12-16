package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Typetb;

public interface TypeService {
	
	/**
	 * 获取所有帖子分类对象
	 * @return
	 */
	public List<Typetb> getAllType();

}
