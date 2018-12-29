package com.ysd.iep.dao;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Sectionexamrubric;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试题干dao
 */
public interface SectionexamrubricDao extends JpaRepository<Sectionexamrubric, String> {
}
