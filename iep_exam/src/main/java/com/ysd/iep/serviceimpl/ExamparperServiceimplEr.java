package com.ysd.iep.serviceimpl;


import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.dao.PerformanceDao;
import com.ysd.iep.dao.StudentexamlogDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Performance;
import com.ysd.iep.entity.Studentexamlog;
import com.ysd.iep.entity.parameter.LookparperQuery;
import com.ysd.iep.entity.parameter.Student;
import com.ysd.iep.feign.AdminFrign;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.service.ExamparperServiceEr;
import com.ysd.iep.util.RemoveDouble;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试卷Service 实现类
 */
@Service
public class ExamparperServiceimplEr implements ExamparperServiceEr {

    @Autowired
    ExamparperDao examparperdao;
    @Autowired
    StudentexamlogDao studentexamlogdao;
    @Autowired
    ExamrubricDao examrubricdao;
    @Autowired(required = false)
    private AdminFrign adminfrign;

    @Autowired
    PerformanceDao performancedao;


    /**
     * @return 查询考试过的卷子的集合
     */
    @Override
    public List<Examparper> queryexamendparper(String userid) {
        return examparperdao.queryexamendforuserid(userid);
    }

    /**
     * 根据卷子的id查询考试过这张卷子的学生id的集合
     */
    @Override
    public List<Student> querstudentidforparperid(String parperid) {
        //List<Studentexamlog> studentexamlogList = studentexamlogdao.selecttotalforparperid(parperid);
        List<Performance> performanceList = performancedao.selectperformanforparperid(parperid);
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < performanceList.size(); i++) {
            String studentid = performanceList.get(i).getStudentId();
            stringList.add(studentid);
        }


        List<String> stringList1 = RemoveDouble.removeDuplicate(stringList);
        List<Student> studentList = new ArrayList<>();
        for (int j = 0; j < stringList1.size(); j++) {
            Result stu = adminfrign.getNameById(stringList1.get(j));
            System.out.println("学生*********************" + stu);
            String sname = stu.getMessage().toString();
            Student student = new Student();
            student.setStuid(stringList1.get(j));
            student.setSname(sname);
            studentList.add(student);
        }
        System.out.println("学生集合****************" + studentList);
        return studentList;
    }

    /**
     * 根据学生id,试卷id查询学生的做题记录  查询试卷
     */
    @Override
    public List<LookparperQuery> querylogforstudentandparperid(String studentid, String parperid) {

        List<LookparperQuery> lookparperQueries = new ArrayList<>();

        Result stu = adminfrign.getNameById(studentid);
        String sname = stu.getMessage().toString();

        List<Studentexamlog> studentexamlogList = studentexamlogdao.selectlogforstudentidandparperid(studentid, parperid);
        List<String> stringList = new ArrayList<>();

        List<Examrubric> examrubricslist = examparperdao.findById(parperid).orElse(null).getExamrubricslist();

        Performance performance = performancedao.selectperformanforparperidandstudentid(parperid, studentid);


        for (int i = 0; i < studentexamlogList.size(); i++) {
            String examrubricid = studentexamlogList.get(i).getExamrubricId();
            stringList.add(examrubricid);
        }

        for (int k = 0; k < examrubricslist.size(); k++) {
            StringBuilder duoid = new StringBuilder();
            StringBuilder duoider = new StringBuilder();

            LookparperQuery lookparperQuery = new LookparperQuery();
            lookparperQuery.setSname(sname);
            lookparperQuery.setTotal(performance.getTotal());
            lookparperQuery.setRubrictype(examrubricslist.get(k).getRubricttype());
            lookparperQuery.setIndex(k + 1);//题目编号
            lookparperQuery.setScore(examrubricslist.get(k).getScore());//题目分数
            lookparperQuery.setContent(examrubricslist.get(k).getContent());


            if (examrubricslist.get(k).getRubricttype().equals("单选题")) {
                lookparperQuery.setSeen(true);
                System.out.println("此为单选题");
                for (int l = 0; l < examrubricslist.get(k).getExamanswers().size(); l++) {


                    if (examrubricslist.get(k).getExamanswers().get(l).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(examrubricslist.get(k).getExamanswers().get(l).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(l).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(examrubricslist.get(k).getExamanswers().get(l).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(l).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(examrubricslist.get(k).getExamanswers().get(l).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(l).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(examrubricslist.get(k).getExamanswers().get(l).getContent());
                    }

                    if (examrubricslist.get(k).getAnswerId().equals(examrubricslist.get(k).getExamanswers().get(l).getId())) {
                        lookparperQuery.setAnswer(examrubricslist.get(k).getExamanswers().get(l).getOptiones());
                    }

                    for (int n = 0; n < studentexamlogList.size(); n++) {
                        if (studentexamlogList.get(n).getExamrubricId().equals(examrubricslist.get(k).getId())) {
                            if (studentexamlogList.get(n).getSelectId().equals(examrubricslist.get(k).getExamanswers().get(l).getId())) {
                                lookparperQuery.setSelectanswer(examrubricslist.get(k).getExamanswers().get(l).getOptiones());
                            }
                        }
                    }
                }
            } else if (examrubricslist.get(k).getRubricttype().equals("多选题")) {
                lookparperQuery.setSeen(true);
                for (int m = 0; m < examrubricslist.get(k).getExamanswers().size(); m++) {
                    if (examrubricslist.get(k).getExamanswers().get(m).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(examrubricslist.get(k).getExamanswers().get(m).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(m).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(examrubricslist.get(k).getExamanswers().get(m).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(m).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(examrubricslist.get(k).getExamanswers().get(m).getContent());
                    }
                    if (examrubricslist.get(k).getExamanswers().get(m).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(examrubricslist.get(k).getExamanswers().get(m).getContent());
                    }
                    String[] split = examrubricslist.get(k).getAnswerId().split(",");
                    for (int q = 0; q < split.length; q++) {
                        if (split[q].equals(examrubricslist.get(k).getExamanswers().get(m).getId())) {
                            /* lookparperQuery.setAnswer(examrubricslist.get(i).getExamanswers().get(j).getId());*/
                            duoid.append(examrubricslist.get(k).getExamanswers().get(m).getOptiones() + " ");
                        }
                    }

                    for (int n = 0; n < studentexamlogList.size(); n++) {
                        String[] spliter = studentexamlogList.get(n).getSelectId().split(",");

                        if (studentexamlogList.get(n).getExamrubricId().equals(examrubricslist.get(k).getId())) {
                            for (int r = 0; r < spliter.length; r++) {
                                if (split[r].equals(examrubricslist.get(k).getExamanswers().get(m).getId())) {
                                    duoider.append(examrubricslist.get(k).getExamanswers().get(m).getOptiones() + " ");
                                }
                            }

                        }
                    }

                }
                lookparperQuery.setAnswer(duoid.toString());
                lookparperQuery.setSelectanswer(duoider.toString());

            } else {
                for (int n = 0; n < studentexamlogList.size(); n++) {
                    lookparperQuery.setSeen(false);
                    lookparperQuery.setAnswer(examrubricslist.get(k).getAnswerId());
                    if (studentexamlogList.get(n).getExamrubricId().equals(examrubricslist.get(k).getId())) {
                        lookparperQuery.setSelectanswer(studentexamlogList.get(n).getSelectId());
                    }
                }
            }
            lookparperQueries.add(lookparperQuery);
        }
        return lookparperQueries;
    }

    /**
     * 刚刚进入考试的时候查询考试记录表中的内容,有就返回
     */
    @Override
    public List<Studentexamlog> querynewlogforstudentandparperid(String studentid, String parperid) {
        List<Studentexamlog> studentexamlogList = studentexamlogdao.selectlogforstudentidandparperid(studentid, parperid);
        return studentexamlogList;
    }

    /**
     * 根据学生id,以及课程id查询学生考试过的卷子
     */
    @Override
    public List<Examparper> queryexamendparperwherestudentid(String studentid, Integer courseid) {
        List<Studentexamlog> studentexamlogList = studentexamlogdao.selectlogforstudentid(studentid, courseid);
        List<Examparper> examparperList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < studentexamlogList.size(); i++) {
            String string = studentexamlogList.get(i).getExamparperId();
            stringList.add(string);
        }
        List<String> stringList1 = RemoveDouble.removeDuplicate(stringList);
        for (int j = 0; j < stringList1.size(); j++) {
            Examparper examparper = examparperdao.findById(stringList1.get(j)).orElse(null);
            examparperList.add(examparper);
        }
        return examparperList;
    }

}
