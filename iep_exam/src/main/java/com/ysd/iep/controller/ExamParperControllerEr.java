package com.ysd.iep.controller;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.dao.SectionexamrubricDao;
import com.ysd.iep.dao.StudentexamlogDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.Studentexamlog;
import com.ysd.iep.entity.parameter.LookparperQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.Student;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamparperService;
import com.ysd.iep.service.ExamparperServiceEr;
import com.ysd.iep.service.SectionrubricService;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试卷 控制器
 */
@RestController
@RequestMapping("/examparper")
public class ExamParperControllerEr {

    @Autowired
    ExamparperDao examparperdao;
    @Autowired
    ExamparperServiceEr examparperserviceer;
    @Autowired
    SectionexamparperDao sectionexamparperdao;
    @Autowired
    SectionrubricService sectionrubricservice;


    /**
     * 新增试卷类
     */
    @RequestMapping(value = "/addparper", method = RequestMethod.POST)
    public Object addparper(ExamParperSerch examParperSerch) {


        try {
            String id = UUIDUtils.getUUID();
            /*弄出来一个新的考试试卷对象*/
            Examparper examparper = examparperdao.save(new Examparper(id, examParperSerch.getType(), examParperSerch.getTitle(), examParperSerch.getSubject(), examParperSerch.getDuration(), "未开放", examParperSerch.getTotal(), null, examParperSerch.getTeacherId(), new Date(), null, null, null, null, null, null,examParperSerch.getExamshortesttime(), null));
            /*将考试试卷的考试试题集合置空*/
            examparper.setExamrubricslist(null);


            return new Result(true, "添加试卷成功", id);


        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加试卷失败", null);

        }
    }

    /**
     * 新增章节测试试卷
     */
    @RequestMapping(value = "/addsesionparper", method = RequestMethod.POST)
    public Object addsesionparper(ExamParperSerch examParperSerch) {
        System.out.println("课程id**************" + examParperSerch.getSubject());
        try {
            String id = UUIDUtils.getUUID();
            /*弄出来一个新的考试试卷对象*/
            Sectionexamparper sectionexamparper = sectionexamparperdao.save(new Sectionexamparper(id, examParperSerch.getSectionId(), examParperSerch.getSubject(), new Date(), null, examParperSerch.getTitle(), null));
            /*将考试试卷的考试试题集合置空*/
            sectionexamparper.setSectionexamrubricslist(null);

            return new Result(true, "添加章节测试试卷成功", id);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加章节测试试卷失败", null);

        }
    }

    /**
     * 根据教师id查询出教师试卷中考试结束的卷子集合
     */
    @RequestMapping(value = "/queryexamendparper", method = RequestMethod.POST)
    public List<Examparper> queryexamendparper(String userid) {
        return examparperserviceer.queryexamendparper(userid);
    }


    /**
     * 根据卷子的id查询考试过这张卷子的学生的集合
     */
    @RequestMapping(value = "/querstudentidforparperid", method = RequestMethod.POST)
    public List<Student> querstudentidforparperid(String parperid) {
        return examparperserviceer.querstudentidforparperid(parperid);
    }

    /**
     * 根据学生id,试卷id查询学生的做题记录  查询试卷
     */
    @RequestMapping(value = "/querylogforstudentandparperid", method = RequestMethod.POST)
    public List<LookparperQuery> querylogforstudentandparperid(String studentid, String parperid) {
        return examparperserviceer.querylogforstudentandparperid(studentid, parperid);
    }

    /**
     * 刚刚进入考试的时候查询考试记录表中的内容,有就返回
     */
    @RequestMapping(value = "/querynewlogforstudentandparperid", method = RequestMethod.POST)
    public List<Studentexamlog> querynewlogforstudentandparperid(String studentid, String parperid) {
        return examparperserviceer.querynewlogforstudentandparperid(studentid, parperid);
    }

    /**
     * 根据学生id查询学生考试过的卷子
     */
    @RequestMapping(value = "/queryexamendparperwherestudentid", method = RequestMethod.POST)
    public List<Examparper> queryexamendparperwherestudentid(String studentid, Integer courseid) {
        return examparperserviceer.queryexamendparperwherestudentid(studentid, courseid);
    }


}
