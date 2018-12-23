package com.ysd.iep.service.serviceImpl;

import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.repository.StudyRepository;
import com.ysd.iep.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyServiceImpl implements StudyService {
    @Autowired
    private StudyRepository studyRepository;

    /**
     * 查询当前学生某门课的最新学习进度
     */
    public StudentRecord queryStudentRecord(Integer cid, String sid){
        return studyRepository.queryStudentRecord(cid,sid);
    }




}
