package com.ysd.iep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Typetb;
import com.ysd.iep.service.TypeService;
import com.ysd.iep.tools.Result;


@RestController
@RequestMapping(value="type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	/**
	 *   获取全部分类
	 * @return
	 */
	@RequestMapping(value="getAllType")
	public Object getAllType() {
		List<Typetb> typeList=typeService.getAllType();
		return typeList;		
	}
	/**
	 * 模糊查询
	 * @param typeName
	 * @returns
	 */
	@RequestMapping(value="queryByTypeName",method=RequestMethod.POST)
	public Object queryByTypeName(String typeName) {
		List<Typetb> tlist=typeService.queryByTypeName(typeName);
		return tlist;
	}
	
	/**
	 * 添加一个类型
	 * @param typeId
	 * @returns
	 */
	@RequestMapping(value="addOneType",method=RequestMethod.POST)
	public Object addType(String typeName,String typeDescribe) {
		int sf = typeService.queryByName(typeName);
		if (sf > 0) {
			return new Result(false, "新增失败,类型不能相同");
		} else {
			int n = typeService.addType(typeName, typeDescribe);
			if (n > 0) {
				return new Result(true, "新增成功");
			} else {
				return new Result(false, "新增失败");
			}
		}

	}
	
	
	/**
	 * 根据类型id删除类型
	 * @param typeId
	 * @returns
	 */
	@RequestMapping(value="delType",method=RequestMethod.POST)
	public Object delType(Integer typeId) {
		Integer L=typeService.queryptype(typeId);
		if(L>0) {
			
			return new Result(false,"删除失败,类型下有帖子!");
			
		}else {
			int n=typeService.delType(typeId);
			if(n>0) {
				return new Result(true,"删除成功");
			}else {
				return new Result(false,"删除失败");
			}
			
		}
	}
	
	/**
	 * 根据类型查询帖子
	 * @param typeId
	 * @returns
	 */
	@RequestMapping(value="upType" ,method=RequestMethod.POST)
	public Object upType(Integer typeId,String typeName,String typeDescribe) {
		
		int n=typeService.upType(typeId, typeName,typeDescribe);
		if(n>0) {
			return new Result(true,"修改成功");
		}else {
			return new Result(false,"修改失败");
		}
	}
	
	@RequestMapping(value = "/queryNoType" ,method=RequestMethod.POST)
	public Object queryNoType(Integer postId) {
		List<Typetb> tlist = typeService.queryNoType(postId);
		return tlist;
	}

	// 查询用户已拥有的类型
	@RequestMapping(value = "/queryType" ,method=RequestMethod.POST)
	public Object queryType(Integer postId) {
		List<Typetb> list = typeService.queryType(postId);
		return list;
	}

	@RequestMapping(value = "/addPostType" ,method=RequestMethod.POST)
	public Object addPostType(Integer postId, Integer typeId) {
		int n = typeService.addPostType(postId, typeId);
		if (n > 0) {
			return new Result(true,"添加成功");
		} else {
			return new Result(true,"添加失败");
		}
		
	}
	
		@RequestMapping(value = "/rePostType",method=RequestMethod.POST)
		public Object rePostType(Integer postId, Integer typeId) {
			int n = typeService.rePostType(postId, typeId);
			if (n > 0) {
				return new Result(true,"移除成功");
			} else {
				return new Result(true,"移除失败");
			}
		}

}
