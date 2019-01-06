package com.ysd.iep.dao;

import com.ysd.iep.entity.Examanswer;
import com.ysd.iep.entity.Examparper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author gaozhognye
 * @date 2018/12/7
 * 考试选项dao
 */
public interface ExamanswerDao extends JpaRepository<Examanswer, String> {
    /**
     * 考试试题答案排序
     *
     * @param examrubric
     * @return
     */
    @Query(value = "select *from examanswer_tb where examanswer_examrubric_id=?1 ORDER BY optiones ASC", nativeQuery = true)
    List<Examanswer> answerasc(String examrubric);
}
