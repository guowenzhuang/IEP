package com.ysd.iep.repository;

import com.ysd.iep.entity.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 学生学习接口
 */
public interface StudyRepository  extends JpaRepository<StudentRecord ,Integer> {
    /**
     * 查询当前学生某门课的最新学习进度
     */
    @Query(value = "SELECT * FROM studentrecordtb WHERE cid=?1 AND sid=?2 ORDER BY starttime DESC LIMIT 1",nativeQuery =true )
    public StudentRecord  queryStudentRecord(Integer cid,String sid);
    /**
     * 根据课程id查询学习记录
     */
    public List<StudentRecord> findByCid(Integer cid);


}
