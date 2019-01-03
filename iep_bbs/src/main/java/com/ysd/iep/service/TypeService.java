package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Typetb;

public interface TypeService {
	
	/**
	 * 获取所有帖子分类对象
	 * @return
	 */
	public List<Typetb> getAllType();
	
	/**
	 * 模糊查询
	 * @param typeName
	 * @return
	 */
	public List<Typetb> queryByTypeName(String typeName);
	/**
	 * 新增类型
	 * @param typeName
	 * @return
	 */
	public Integer addType(String typeName,String typeDescribe);
	
	/**
	 * 删除类型
	 * @param typeId
	 * @return
	 */
	public Integer delType(Integer typeId);
	
	/**
	 * 修改类型
	 * @param typeId
	 * @param typeName
	 * @return
	 */
	public Integer upType(Integer typeId,String typeName,String typeDescribe);

	/**
	 * 查询未拥有的分类
	 * @return
	 */
	public List<Typetb> queryNoType(Integer postId);
	/**
	 * 查询已拥有的分类
	 * @return
	 */
	public List<Typetb> queryType(Integer postId);
	/**
	 * 给帖子添加分类
	 * @return
	 */
	public Integer addPostType(Integer postId, Integer typeId);
	/**
	 * 给帖子移除分类
	 * @return
	 */
	public Integer rePostType(Integer postId, Integer typeId);
	
	/**
	 *   查询分类下是否有帖子
	 * @param typeId
	 * @return
	 */
	public Integer queryptype(Integer typeId);
	
	/**
	 *   查询分类下名字是否相同
	 * @param typeName
	 * @return
	 */
	public Integer queryByName(String typeName);

}
