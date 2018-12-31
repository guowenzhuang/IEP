package com.ysd.iep.dao;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Sectionexamparper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
    List<Sectionexamparper> selectsectionparperwherecourseandsection(Integer course, Integer section);

    /**
     * 根据课程id,章节id章节测试试卷id删除试卷
     *
     * @param courseid
     * @param sectionid
     * @param parperid
     * @return
     */

    @Query(value = "delete from sectionexamparper_tb where course_id=?1 and section_id=?2 and id=?3", nativeQuery = true)
    @Modifying
    @Transactional
    public Integer deletsectionforcourseidandsectionidparperid(Integer courseid, Integer sectionid, String parperid);


    /**
     * 根据课程查询章节下所有的章节测试
     */
    @Query(value = "select *from  sectionexamparper_tb  where course_id=?1", nativeQuery = true)
    List<Sectionexamparper> selectsectionparperwherecourseid(Integer course);







}
