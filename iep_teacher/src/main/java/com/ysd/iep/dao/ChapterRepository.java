package com.ysd.iep.dao;

import java.util.List;

import com.ysd.iep.entity.dto.Result;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.Chapters;

import javax.transaction.Transactional;

public interface ChapterRepository extends JpaRepository<Chapters, Integer>{

	/**
	 * 
	 * @param parentId
	 * @return
	 */
	@Query(value = "SELECT * FROM chaptertb WHERE cha_parentid=?1 and cha_courid=?2   ORDER BY cha_id asc", nativeQuery = true)
	public List<Chapters> queryTreeChildrenById(Integer parentId,Integer courId);
	
	/**
	 * 查询子菜单
	 * @param parentId
	 * @return
	 */
	@Query(value = "SELECT * FROM chaptertb WHERE cha_parentid=?1", nativeQuery = true)
	public List<Chapters> queryChildren(Integer parentId);

	/**
	 * 根据课程Id查询章节的总条数
	 * @param chaCourid
	 * @return
	 */
	@Query(value = "select cha_id from chaptertb where cha_courid=?1 and cha_parentid=0 order by cha_id", nativeQuery = true)
	List<Integer> queryCountById(Integer chaCourid);
    /**
     * 查询子菜单
     * @param parentId
     * @return
     */
    @Query(value = "SELECT cha_id FROM chaptertb WHERE cha_parentid=?1 order by cha_id", nativeQuery = true)
    List<Integer> queryIdByParentId(Integer parentId);


}
