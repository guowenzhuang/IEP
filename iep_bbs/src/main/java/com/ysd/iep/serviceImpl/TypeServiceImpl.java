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
	
	@Override
	public List<Typetb> queryByTypeName(String typeName) {
		// TODO Auto-generated method stub
		return typeRepository.findByTypeNameContaining(typeName);
	}
	@Override
	public Integer addType(String typeName,String typeDescribe) {
		// TODO Auto-generated method stub
		return typeRepository.addType(typeName,typeDescribe);
	}
	@Override
	public Integer delType(Integer typeId) {
			return typeRepository.deleteType(typeId);
		
	}
	@Override
	public Integer upType(Integer typeId,String typeName,String typeDescribe) {
		// TODO Auto-generated method stub
		return typeRepository.upTypeById(typeId,typeName,typeDescribe);
	}

	@Override
	public List<Typetb> queryNoType(Integer postId) {
		// TODO Auto-generated method stub
		List<Typetb> Typetbs=typeRepository.queryNoTypes(postId);
		return Typetbs;
	}

	@Override
	public List<Typetb> queryType(Integer postId) {
		// TODO Auto-generated method stub
		List<Typetb> Typetbs=typeRepository.queryTypes(postId);

		return Typetbs;
		
	}

	@Override
	public Integer addPostType(Integer postId, Integer typeId) {
		// TODO Auto-generated method stub
		return typeRepository.addPostType(postId, typeId);
	}

	@Override
	public Integer rePostType(Integer postId, Integer typeId) {
		// TODO Auto-generated method stub
		return typeRepository.rePostType(postId,typeId);
	}
	
	@Override
	public Integer queryptype(Integer typeId) {
		return typeRepository.queryptype(typeId);
	}

}
