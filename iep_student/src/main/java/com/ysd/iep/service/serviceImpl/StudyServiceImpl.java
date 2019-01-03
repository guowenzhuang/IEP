package com.ysd.iep.service.serviceImpl;
import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.repository.StudyRepository;
import com.ysd.iep.service.StudyService;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 新增学习记录
     * @param studentRecord
     * @return
     */
    public Result insertChapters(StudentRecord studentRecord){
      try{
          studyRepository.save(studentRecord);
          return new Result(true,"学习记录成功");
      }catch (Exception e){
          return new Result(true,"学习记录失败");
      }
    }

    public List<StudentRecord> findByCid(Integer cid){
        return studyRepository.findByCid(cid);
    }

}
