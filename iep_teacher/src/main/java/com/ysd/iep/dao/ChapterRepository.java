package com.ysd.iep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.iep.entity.Chapters;

public interface ChapterRepository extends JpaRepository<Chapters, Integer>{

	/**
	 * 
	 * @param parentId
	 * @return
	 */
	@Query(value = "SELECT * FROM chaptertb WHERE cha_parentid=?1  ORDER BY cha_id asc", nativeQuery = true)
	public List<Chapters> queryTreeChildrenById(Integer parentId);
}
