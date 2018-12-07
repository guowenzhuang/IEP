package com.ysd.iep.dao;

import com.ysd.iep.entity.Sectionexamparper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 章节测试表dao
 */
public interface SectionexamDao extends JpaRepository<Sectionexamparper, String> {
}
