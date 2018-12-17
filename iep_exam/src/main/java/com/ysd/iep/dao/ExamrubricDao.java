package com.ysd.iep.dao;

import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
=======
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
>>>>>>> 7011793fcc768bb1fd0e9e3ddc4fef754e20dcae

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试题干dao
 */
<<<<<<< HEAD
public interface ExamrubricDao extends JpaRepository<Examrubric, String> {

    //利用原生的SQL进行插入操作
    @Query(value = "insert into examrubric_tb(id,section_id,course_id,answer_id,content,trcher_id,score,rubricttype) value(:#{#examrubric.id},:#{#examrubric.sectionId},:#{#examrubric.courseId},:#{#examrubric.answerId},:#{#examrubric.content},:#{#examrubric.trcherId},:#{#examrubric.score},:#{#examrubric.rubricttype})", nativeQuery = true)
    @Modifying
    @Transactional
    int insertintoExamrubric(@Param("examrubric")Examrubric examrubric);
=======
public interface ExamrubricDao extends JpaRepository<Examrubric, String>, JpaSpecificationExecutor<Examrubric> {
>>>>>>> 7011793fcc768bb1fd0e9e3ddc4fef754e20dcae
}
