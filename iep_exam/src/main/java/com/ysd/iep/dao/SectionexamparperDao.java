package com.ysd.iep.dao;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Sectionexamparper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试卷子dao
 */
public interface SectionexamparperDao extends JpaRepository<Sectionexamparper, String> {
    /***
     * 查询本门课程下的未开考测试试卷
     * @param
     * @return
     */
    @Query(value = "select *from  sectionexamparper_tb  where course_id=?1 and section_id=?2", nativeQuery = true)
    List<Sectionexamparper> selectsectionparperwherecourseandsection(String course, String section);


}
