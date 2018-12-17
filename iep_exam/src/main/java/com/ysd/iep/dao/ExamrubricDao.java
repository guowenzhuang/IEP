package com.ysd.iep.dao;

import com.ysd.iep.entity.Examrubric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试题干dao
 */
public interface ExamrubricDao extends JpaRepository<Examrubric, String> {

    //利用原生的SQL进行插入操作
    @Query(value = "insert into examrubric_tb(id,section_id,course_id,answer_id,content,trcher_id,score,rubricttype) value(:#{#examrubric.id},:#{#examrubric.sectionId},:#{#examrubric.courseId},:#{#examrubric.answerId},:#{#examrubric.content},:#{#examrubric.trcherId},:#{#examrubric.score},:#{#examrubric.rubricttype})", nativeQuery = true)
    @Modifying
    @Transactional
    int insertintoExamrubric(@Param("examrubric")Examrubric examrubric);
}
