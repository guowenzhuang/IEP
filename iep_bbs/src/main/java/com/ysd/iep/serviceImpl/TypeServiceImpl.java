package com.ysd.iep.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.TypeRepository;
import com.ysd.iep.entity.Typetb;
import com.ysd.iep.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{
	@Autowired
	private TypeRepository typeRepository;

	@Override
	public List<Typetb> getAllType() {
		return typeRepository.findAll();
	}

}
