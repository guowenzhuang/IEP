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
	 * 根据章节id修改视频的路径和视频的时长
	 * @param chaViurl
	 * @param chaTime
	 * @param courId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query(value = "update chaptertb set cha_viurl=?1,cha_time=?2,cha_name=?3 where cha_id=?4", nativeQuery = true)
    public Integer updateChaViurlAtime(String chaViurl,String chaTime,String chaName,Integer courId);

}
