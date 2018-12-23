package com.ysd.iep.service;

import com.ysd.iep.entity.StudentRecord;

public interface StudyService {
    /**
     * 查询当前学生某门课的最新学习进度
     */
    public StudentRecord queryStudentRecord(Integer cid,String sid);

}
