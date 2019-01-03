package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QueryTestQuestionBankInterface {
    @Autowired
    private ExamparperDao examparperDao;
    @Autowired
    private RubricDao rubricDao;
    @Autowired
    private SectionexamparperDao sectionexamparperDao;

    /***
     * 查询课程下的所有试卷.章节测试,题库
     * @param coureId
     * @return
     */
    public Result query(Integer coureId){
        List<Examparper> examparpers=examparperDao.findBySubject(String.valueOf(coureId));
        List<Rubric> rubricList=rubricDao.findByCourseId(coureId);
        List<Sectionexamparper> sectionexamparperList=sectionexamparperDao.selectsectionparperwherecourseid(coureId);
        if (examparpers.size()!=0){
            return new Result(false,"本课程下有试卷,请先删除试卷",null);
        }else if (rubricList.size()!=0){
            return new Result(false,"本课程下题库有题,请先删除题目",null);
        }else if (sectionexamparperList.size()!=0){
            return new Result(false,"本课程下章节测试,请先删除章节测试",null);
        }else {
            return new Result(true,null,null);
        }

    }
}
