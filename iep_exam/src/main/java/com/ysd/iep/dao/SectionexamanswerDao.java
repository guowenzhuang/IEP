package com.ysd.iep.dao;

import com.ysd.iep.entity.Examanswer;
import com.ysd.iep.entity.Sectionexamanswer;
import com.ysd.iep.entity.Sectionexamparper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试选现dao
 */
public interface SectionexamanswerDao extends JpaRepository<Sectionexamanswer, String> {

    @Query(value = "select *from sectionexamanswer_tb where sectionexamanswer_sectionexamrubric_id=?1 ORDER BY optiones ASC", nativeQuery = true)
    List<Sectionexamanswer> sectionanswerasc(String sectionexamrubric);


}
