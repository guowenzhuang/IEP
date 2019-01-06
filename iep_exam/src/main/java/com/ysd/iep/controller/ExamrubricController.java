package com.ysd.iep.controller;


import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.entitySerch.ExamParperSerch;

import com.ysd.iep.rabbit.producer.FanoutProducer;
import com.ysd.iep.service.ExamrubricService;
import com.ysd.iep.service.RubricService;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * <p>
 * 考试试卷Controller层
 */
@RestController
@RequestMapping("/examrubric")
public class ExamrubricController {

    @Autowired
    ExamrubricService examrubricservice;
    @Autowired
    RubricService rubricservice;
    @Autowired
    FanoutProducer fanoutProducer;
    /**
     * 多条件分页查询所有考试试题
     */
    @RequestMapping(value = "/queryexamrubric", method = RequestMethod.POST)
    public ExamrubricFan queryexamrubric(RubricQuery rubricquery, Integer page, Integer rows) {
        Page<Examrubric> examrubric = examrubricservice.queryExamrubricByuserQuery(rubricquery, page, rows);
        Integer total = (int) examrubric.getTotalElements();
        List<Examrubric> list = examrubric.getContent();

        list.forEach(item -> {
            item.getExamanswers().forEach(t -> {
                t.setExamrubric(null);
            });
        });


        return new ExamrubricFan(total, list);
    }

    /**
     * 根据试卷id查询考试试题
     */
    @RequestMapping(value = "/getExamrubricforparperid", method = RequestMethod.POST)
    public List<LookparperQuery> getExamrubricforparperid(RubricQuery rubricquery) {


        List<Examrubric> examrubricslist = examrubricservice.getExamrubricforparperid(rubricquery);
        List<LookparperQuery> lookparperQueries = new ArrayList<>();


        for (int i = 0; i < examrubricslist.size(); i++) {

            StringBuilder duoid = new StringBuilder();
            LookparperQuery lookparperQuery = new LookparperQuery();
            lookparperQuery.setRubrictype(examrubricslist.get(i).getRubricttype());
            lookparperQuery.setIndex(i + 1);//题目编号
            lookparperQuery.setScore(examrubricslist.get(i).getScore());//题目分数
            lookparperQuery.setContent(examrubricslist.get(i).getContent());


            if (examrubricslist.get(i).getRubricttype().equals("单选题")) {
                lookparperQuery.setSeen(true);
                System.out.println("此为单选题");
                for (int j = 0; j < examrubricslist.get(i).getExamanswers().size(); j++) {

                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }

                    if (examrubricslist.get(i).getAnswerId().equals(examrubricslist.get(i).getExamanswers().get(j).getId())) {
                        lookparperQuery.setAnswer(examrubricslist.get(i).getExamanswers().get(j).getOptiones());
                    }

                }

            } else if (examrubricslist.get(i).getRubricttype().equals("多选题")) {
                lookparperQuery.setSeen(true);
                for (int j = 0; j < examrubricslist.get(i).getExamanswers().size(); j++) {
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("A")) {
                        lookparperQuery.setAnswerA(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("B")) {
                        lookparperQuery.setAnswerB(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("C")) {
                        lookparperQuery.setAnswerC(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }
                    if (examrubricslist.get(i).getExamanswers().get(j).getOptiones().equals("D")) {
                        lookparperQuery.setAnswerD(examrubricslist.get(i).getExamanswers().get(j).getContent());
                    }

                    String[] split = examrubricslist.get(i).getAnswerId().split(",");


                    for (int q = 0; q < split.length; q++) {
                        if (split[q].equals(examrubricslist.get(i).getExamanswers().get(j).getId())) {
                            /* lookparperQuery.setAnswer(examrubricslist.get(i).getExamanswers().get(j).getId());*/
                            duoid.append(examrubricslist.get(i).getExamanswers().get(j).getOptiones() + " ");

                        }
                        lookparperQuery.setAnswer(duoid.toString());
                    }

                }


            } else {
                lookparperQuery.setSeen(false);
                lookparperQuery.setAnswer(examrubricslist.get(i).getAnswerId());
            }

            lookparperQueries.add(lookparperQuery);
        }


        return lookparperQueries;
    }
    /**
     * 新增试题
     */
    @RequestMapping(value = "/addexamrubric", method = RequestMethod.POST)
    public Object addexamrubric(AddrubricQuery addrubricquery) {
        return examrubricservice.addexamrubric(addrubricquery);

    }

    /**
     * 删除考试试题中的试题(根据id)
     */
    @RequestMapping(value = "/deleteexamrubric", method = RequestMethod.POST)
    public Object deleteexamrubric(String examrubricid) {
        return examrubricservice.deleteexamrubric(examrubricid);
    }

    /**
     * 新增考试试题(三中试题) 同时向题库中插入数据
     */
    @RequestMapping(value = "/addexamrubricdouble", method = RequestMethod.POST)
    public Result addexamrubricdouble(AddrubricQuery addrubricquery) {
        Result examrubricresult = null;
        Result examrubricresultdouble = null;
        Result rubricresult = rubricservice.addrubric(addrubricquery);


        if (addrubricquery.getRubrictype().equals("填空题") || addrubricquery.getRubrictype().equals("判断题")) {
            System.out.println("填空判断调用的");
            examrubricresult = examrubricservice.addexamrubric(addrubricquery);
        } else {
            System.out.println("单选多选调用的");
            examrubricresultdouble = examrubricservice.addexamrubricjudegepack(addrubricquery);
        }

        /*examrubricresult.isSuccess();*/
        if (rubricresult.isSuccess() || examrubricresult.isSuccess() || examrubricresultdouble.isSuccess()) {
            return new Result(true, "新增考试以及新增题库题成功!!!!", null);
        } else {
            return new Result(false, "新增考试以及新增题库题失败!!!!", null);
        }
    }

    /**
     * 创建试卷的时候调用
     *
     * @param parperid
     * @return
     */
    @RequestMapping(value = "/createparper", method = RequestMethod.POST)
    public Result createparper(String parperid) {
        return examrubricservice.createparper(parperid);
    }

    /**
     * 点击开始考试按钮
     */
    @RequestMapping(value = "/beginexam", method = RequestMethod.POST)
    public Result beginexam(BeginexamQuery beginexamQuery) throws ParseException {
        return examrubricservice.beginexam(beginexamQuery);
    }

    /**
     * 根据试卷id获取试卷
     */
    @RequestMapping(value = "/queryexamrubricer", method = RequestMethod.POST)
    public QueryExamRubricFan queryexamrubricer(RubricQuery rubricQuery) throws ParseException {
        return examrubricservice.queryexamrubric(rubricQuery);
    }

    /**
     * 考试过之后成绩处理(单题的改卷处理)
     */
    @RequestMapping(value = "/examend", method = RequestMethod.POST)
    public Object examend(ExamUltimately examUltimately) {
        return examrubricservice.examend(examUltimately);
    }
    /**
     * RabbitMQ消息队列___考试过之后成绩处理(单题的改卷处理)
     */
  /*  @RequestMapping(value = "/examend", method = RequestMethod.POST)
    public Object examend(ExamUltimately examUltimately) {

        try {
            fanoutProducer.sendTestLog(examUltimately);
return new Result(true,"已发送到消息队列",null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"发送失败",null);
        }

    }*/

    /**
     * 整个试卷做完之后点击交卷时候
     */
    @RequestMapping(value = "/examination", method = RequestMethod.POST)
    public Object examination(ExamUltimately examUltimately) throws ParseException {
        return examrubricservice.examination(examUltimately);
    }


}
