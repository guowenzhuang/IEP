package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.PerformanceDao;
import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.dao.SectionexamrubricDao;
import com.ysd.iep.entity.Performance;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.service.SectionexamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/30
 * 章节测试试卷service实现类
 */

@Service
public class SectionexamparperServiceimpl implements SectionexamparperService {
    @Autowired
    SectionexamparperDao sectionexamparperdao;
    @Autowired(required = false)
    private TeacherFeign teacherfeign;
    @Autowired
    PerformanceDao performancedao;
    @Autowired
    SectionexamrubricDao sectionexamrubricdao;


    /**
     * 根据课程id 章节id查询 章节测试试卷
     */
    @Override
    public List<Sectionexamparper> selectparperforcoueseidandsectionid(Integer courseid, Integer sectionid) {

        List<Sectionexamparper> sectionexamparperList = sectionexamparperdao.selectsectionparperwherecourseandsection(courseid, sectionid);
        for (int i = 0; i < sectionexamparperList.size(); i++) {
            sectionexamparperList.get(i).setSectionexamrubricslist(null);
        }

        return sectionexamparperList;
    }

    /**
     * 根据课程id,章节id章节测试试卷id删除试卷
     *
     * @param courseid
     * @param sectionid
     * @param parperid
     * @return
     */
    @Override
    public Result deletsectionforcourseidandsectionidparperid(Integer courseid, Integer sectionid, String parperid) {
        int r = sectionexamparperdao.deletsectionforcourseidandsectionidparperid(courseid, sectionid, parperid);
        if (r > 0) {
            return new Result(true, "移除章节测试试卷成功", null);
        } else {
            return new Result(false, "移除章节测试试卷失败", null);
        }
    }

    /**
     * 根据章节考试试卷id 查看章节测试题目
     */
    @Override
    public List<LookparperQuery> selectsectionparperrubric(String parperid) {

        Sectionexamparper sectionexamparper = sectionexamparperdao.findById(parperid).orElse(null);

        /*List<Sectionexamrubric> sectionexamrubricList = sectionexamparper.getSectionexamrubricslist();*/
        List<Sectionexamrubric> sectionexamrubricList = sectionexamrubricdao.selectsectionrubricforparperid(parperid);

        List<LookparperQuery> lookparperQueries = new ArrayList<>();
        System.out.println("题目数量****************" + sectionexamrubricList.size());

        for (int i = 0; i < sectionexamrubricList.size(); i++) {

            StringBuilder duoid = new StringBuilder();
            LookparperQuery lookparperQuery = new LookparperQuery();
            lookparperQuery.setRubrictype(sectionexamrubricList.get(i).getRubricttype());
            lookparperQuery.setIndex(i + 1);//题目编号
            lookparperQuery.setScore(sectionexamrubricList.get(i).getScore());//题目分数
            lookparperQuery.setContent(sectionexamrubricList.get(i).getContent());


            if (sectionexamrubricList.get(i).getRubricttype().equals("单选题")) {
                lookparperQuery.setSeen(true);
                System.out.println("此为单选题");
                for (int j = 0; j < sectionexamrubricList.get(i).getExamanswers().size(); j++) {

                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }

                    if (sectionexamrubricList.get(i).getAnswerId().equals(sectionexamrubricList.get(i).getExamanswers().get(j).getId())) {
                        lookparperQuery.setAnswer(sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones());
                    }

                }

            } else if (sectionexamrubricList.get(i).getRubricttype().equals("多选题")) {
                lookparperQuery.setSeen(true);
                for (int j = 0; j < sectionexamrubricList.get(i).getExamanswers().size(); j++) {
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }
                    if (sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(sectionexamrubricList.get(i).getExamanswers().get(j).getContent());
                    }

                    String[] split = sectionexamrubricList.get(i).getAnswerId().split(",");


                    for (int q = 0; q < split.length; q++) {
                        if (split[q].equals(sectionexamrubricList.get(i).getExamanswers().get(j).getId())) {
                            /* lookparperQuery.setAnswer(examrubricslist.get(i).getExamanswers().get(j).getId());*/
                            duoid.append(sectionexamrubricList.get(i).getExamanswers().get(j).getOptiones() + " ");

                        }
                        lookparperQuery.setAnswer(duoid.toString());
                    }

                }


            } else {
                lookparperQuery.setSeen(false);
                lookparperQuery.setAnswer(sectionexamrubricList.get(i).getAnswerId());
            }

            lookparperQueries.add(lookparperQuery);
        }


        return lookparperQueries;
    }


    /**
     * 根据课程查询所有的父章节   以及根据课程id查询所有的试卷
     */
    @Override
    public SectionexamQuery selectsectionandparper(Integer courseid) {
        com.ysd.iep.util.Result<List<Chapters>> chaptersList = teacherfeign.queryParentChapter(courseid);
        List<Sectionexamparper> sectionexamparperList = sectionexamparperdao.selectsectionparperwherecourseid(courseid);
        for (int i = 0; i < sectionexamparperList.size(); i++) {
            sectionexamparperList.get(i).setSectionexamrubricslist(null);
        }

        return new SectionexamQuery(sectionexamparperList, chaptersList);
    }

    /**
     * 根据章节测试卷子id 学生id查询出所有的成绩记录,返回测验的次数  以及最高的分数 ,以及最近一次提交的时间
     */
    @Override
    public List<permanceFan> selecttotalandnumandmaxtotal(String parperid, String studentid) {

        List<Performance> performanceList = performancedao.selectperformanforparperidandstudentider(parperid, studentid);
        /**
         * 成绩表中的这个学生的考试次数
         */
        Integer examnum = performanceList.size();
        /**
         * 最高的成绩min
         */
        List<Integer> totallist = new ArrayList<>();

        for (int i = 0; i < performanceList.size(); i++) {
            totallist.add(performanceList.get(i).getTotal());
        }


        Integer min = totallist.get(0);

        for (Integer item : totallist) {
            if (item.intValue() > min) {
                min = item;
            }
        }
        /**
         * 取出距离当前时间最近的一次的考试记录
         */
        Performance performance = performancedao.mintimenowperformance(studentid, parperid);

        Date time = performance.getCreatetime();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");

        List<permanceFan> permanceFanList = new ArrayList<>();

        permanceFan p = new permanceFan(examnum, min, s.format(time));


        return permanceFanList;
    }


}
