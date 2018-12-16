package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Typetb;
import com.ysd.iep.service.TypeService;


@RestController
@RequestMapping(value="type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value="getAllType")
	public Object getAllType() {
		List<Typetb> typeList=typeService.getAllType();
		return typeList;		
	}

}
