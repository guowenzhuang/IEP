package com.ysd.iep.service;

import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.util.Result;

import java.util.List;

public interface StudyService {
    /**
     * 查询当前学生某门课的最新学习进度
     */
    public StudentRecord queryStudentRecord(Integer cid,String sid);

    /**
     * 添加学习记录
     *
     * @param studentRecord
     * @return
     */
    Result insertChapters(StudentRecord studentRecord);

    public List<StudentRecord> findByCid(Integer cid);

}
