package com.ysd.iep.dao;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Performance;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamrubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试题干dao
 */
public interface SectionexamrubricDao extends JpaRepository<Sectionexamrubric, String>, JpaSpecificationExecutor<Sectionexamrubric> {

    @Query(value = "delete from sectionexamrubric_tb where id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    public Integer deletforexamrubricid(String sectionexamrubricid);


    /**
     * 根据章节测试试卷id查询章节测试试题
     *
     * @param parperid
     * @return
     */
    @Query(value = "SELECT * from sectionexamrubric_tb where sectionexamrubric_sectionexamparper_id =?1", nativeQuery = true)
    List<Sectionexamrubric> selectsectionrubricforparperid(String parperid);



}
