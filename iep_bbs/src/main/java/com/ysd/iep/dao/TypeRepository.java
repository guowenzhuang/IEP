package com.ysd.iep.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.Typetb;

public interface TypeRepository extends JpaRepository<Typetb, Integer>{
	   //按名称模糊查询
		public List<Typetb> findByTypeNameContaining(String typeName);
		//添加类型
		@Query(value="insert into typetb (type_name,type_describe) values (?1,?2)",nativeQuery= true)
		@Modifying
		@Transactional
		public Integer addType(String typeName,String typeDescribe);
	    /**
	     * 删除分类
	     * @param postId
	     * @param typeId
	     * @return
	     */
		@Query(value = "DELETE FROM typetb WHERE type_id=?1", nativeQuery = true)
		@Modifying
		@Transactional
		public Integer deleteType(Integer typeId);

		//修改类型
		@Query(value="UPDATE typetb SET type_name=?2,type_describe=?3  WHERE type_id=?1",nativeQuery= true)
		@Modifying
		@Transactional
		public Integer upTypeById(Integer typeId,String typeName,String typeDescribe);
		
		//帖子类型操作
		/**
		 * 查询帖子已有的分类
		 * @param postId
		 * @return
		 */
		 @Query(value = "SELECT* FROM typetb WHERE type_id IN \r\n" + 
					"(SELECT type_id FROM posttypetb WHERE post_id=?1)", nativeQuery = true)
		 public List<Typetb> queryTypes(Integer postId);
		/**
		 * 查询帖子没有的分类
		 * 
		 * @param postId
		 * @return
		 */
		@Query(value = "SELECT* FROM typetb WHERE type_id NOT IN\r\n"
				+ "(SELECT type_id FROM posttypetb WHERE post_id=?1)", nativeQuery = true)
		public List<Typetb> queryNoTypes(Integer postId);
	    /**
	     * 给帖子添加分类
	     * @param postId
	     * @param typeId
	     * @return
	     */
		@Query(value = "INSERT INTO posttypetb(post_id,type_id) VALUES (?1,?2)", nativeQuery = true)
		@Modifying
		@Transactional
		public Integer addPostType(Integer postId, Integer typeId);
	    /**
	     * 删除帖子分类
	     * @param postId
	     * @param typeId
	     * @return
	     */
		@Query(value = "DELETE FROM posttypetb WHERE type_id=?2 AND post_id=?1", nativeQuery = true)
		@Modifying
		@Transactional
		public Integer rePostType(Integer postId,Integer typeId);
		
		/**
		 * 查询该类型下有没有帖子
		 * @param typeId
		 * @return
		 */
		@Query(value = "SELECT COUNT(1) FROM posttypetb WHERE type_id=?1", nativeQuery = true)
		public Integer queryptype(Integer typeId);
		
		// 判断类型名字是否一样
		@Query(value = "SELECT COUNT(*) FROM typetb WHERE type_name=?1", nativeQuery = true)
		public Integer queryByName(String typeName);

}
