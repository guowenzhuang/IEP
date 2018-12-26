package com.ysd.iep.serviceimpl;


import com.ysd.iep.dao.*;
import com.ysd.iep.entity.*;
import com.ysd.iep.entity.parameter.*;
import com.ysd.iep.service.ExamrubricService;
import com.ysd.iep.util.SecondformDate;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试题service 实现类
 */
@Service
public class ExamrubricServiceimpl implements ExamrubricService {

    @Autowired
    ExamrubricDao examrubricdao;
    @Autowired
    ExamanswerDao examanswerdao;
    @Autowired
    ExamparperDao examparperdao;
    @Autowired
    StudentexamlogDao studentexamlogdao;
    @Autowired
    PerformanceDao performancedao;

    /**
     * 多条件分页查询考试试题
     *
     * @param rubricquery
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Page<Examrubric> queryExamrubricByuserQuery(RubricQuery rubricquery, Integer page, Integer rows) {
        Pageable pageable = new PageRequest(page - 1, rows);
        return examrubricdao.findAll(this.getWhereClause(rubricquery), pageable);
    }

    /**
     * 多条件查询(where条件拼接)
     *
     * @param rubricquery
     * @return
     */
    public Specification<Examrubric> getWhereClause(final RubricQuery rubricquery) {
        return new Specification<Examrubric>() {

            @Override
            public Predicate toPredicate(Root<Examrubric> root, CriteriaQuery<?> query, CriteriaBuilder
                    cb) {
                Predicate predicate = cb.conjunction();//动态SQL表达式
                List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合


                if (rubricquery.getExamparper() != null && !"".equals(rubricquery.getExamparper())) {
                    exList.add(cb.equal(root.get("examparper").get("id").as(String.class), rubricquery.getExamparper()));

                }

                if (rubricquery.getUserid() != null && !"".equals(rubricquery.getUserid())) {
                    exList.add(cb.equal(root.get("trcherId").as(String.class), rubricquery.getUserid()));

                }

                if (rubricquery.getRubric() != null && !"".equals(rubricquery.getRubric())) {
                    exList.add(cb.like(root.get("content"), "%" + rubricquery.getRubric() + "%"));

                }
                if (rubricquery.getType() != null && !"".equals(rubricquery.getType())) {
                    exList.add(cb.equal(root.get("rubricttype").as(String.class), rubricquery.getType()));

                }

                return predicate;
            }
        };
    }

    /**
     * 根据试卷id查询考试试题
     */
    @Override
    public List<Examrubric> getExamrubricforparperid(RubricQuery rubricquery) {
        return examrubricdao.findAll(this.getWhereClause(rubricquery));
    }

    /**
     * 新增题目
     *
     * @param addrubricquery
     * @return
     */
    @Override
    public Result addexamrubric(AddrubricQuery addrubricquery) {
        if (addrubricquery.getRubrictype().equals("单选题")) {
            String idanswer = "";
            String id = "";

            List<ABCD> ABCD = new ArrayList<>();
            ABCD.add(new ABCD("A", addrubricquery.getAid()));
            ABCD.add(new ABCD("B", addrubricquery.getBid()));
            ABCD.add(new ABCD("C", addrubricquery.getCid()));
            ABCD.add(new ABCD("D", addrubricquery.getDid()));

            for (int j = 0; j < ABCD.size(); j++) {
                if (addrubricquery.getAnswerid().equals(ABCD.get(j).getId())) {
                    idanswer = ABCD.get(j).getAnswer();
                }
            }


            List<String> idlist = new ArrayList<>();
            //生成五个UUId
            for (int i = 0; i <= 4; i++) {
                idlist.add(UUIDUtils.getUUID());
            }

            List<Examanswer> answers = new ArrayList<>();
            answers.add(new Examanswer(idlist.get(0), "A", addrubricquery.getAnswerA()));
            answers.add(new Examanswer(idlist.get(1), "B", addrubricquery.getAnswerB()));
            answers.add(new Examanswer(idlist.get(2), "C", addrubricquery.getAnswerC()));
            answers.add(new Examanswer(idlist.get(3), "D", addrubricquery.getAnswerD()));


            for (int l = 0; l < answers.size(); l++) {
                if (answers.get(l).getOptiones() == idanswer) {
                    id = answers.get(l).getId();
                }
            }


            try {
                Examrubric rubric = new Examrubric(idlist.get(4), null, addrubricquery.getCourse(), id, addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                Examrubric rubric1 = examrubricdao.save(rubric);

                for (int k = 0; k < answers.size(); k++) {
                    answers.get(k).setExamrubric(rubric1);
                    examanswerdao.save(answers.get(k));
                }
                return new Result(true, "添加成功", null);

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "添加失败", null);
            }
        } else if (addrubricquery.getRubrictype().equals("多选题")) {

            System.out.println("多选添加数据******************" + addrubricquery);


            try {
                /**
                 * 声明一个StringBuilder类型的变量,
                 * 用来存储将id以逗号分隔连起来的字符串 就是这样 UUID,UUID
                 */
                StringBuilder answerid = new StringBuilder();
                /**
                 * 定义一个实体类ABCD,
                 * 用来存放前台传来的在题库中的答案的id=>放在list集合中
                 */

                List<ABCD> ABCD = new ArrayList<>();
                ABCD.add(new ABCD("A", addrubricquery.getAid()));
                ABCD.add(new ABCD("B", addrubricquery.getBid()));
                ABCD.add(new ABCD("C", addrubricquery.getCid()));
                ABCD.add(new ABCD("D", addrubricquery.getDid()));


                StringBuilder list = new StringBuilder();
                /**
                 * 将前台传来的原来的正确答案的id(以逗号分隔的UUID)
                 * 以逗号为标识截开放在String[]数组中,
                 */

                String ids = addrubricquery.getAnswerid();
                String[] split = ids.split(",");
                /**
                 * 将ABCD遍历,然后拿其中的项的id也就是UUID 与  Strign[]数组中的项进行比较,
                 *                 如果相等,将相等的ABCD中的这一项 的answer 也就是ABCD 取出
                 *                 然后以逗号分隔形成一个StringBuilder的list
                 */
                for (int j = 0; j < ABCD.size(); j++) {
                    for (int l = 0; l < split.length; l++) {

                        if (ABCD.get(j).getId().equals(split[l])) {
                            list.append(ABCD.get(j).getAnswer() + ",");


                        }
                    }

                }

                List<String> idlist = new ArrayList<>();
                //生成五个UUId
                for (int i = 0; i <= 4; i++) {
                    idlist.add(UUIDUtils.getUUID());
                }


                List<Examanswer> answers = new ArrayList<>();
                answers.add(new Examanswer(idlist.get(0), "A", addrubricquery.getAnswerA()));
                answers.add(new Examanswer(idlist.get(1), "B", addrubricquery.getAnswerB()));
                answers.add(new Examanswer(idlist.get(2), "C", addrubricquery.getAnswerC()));
                answers.add(new Examanswer(idlist.get(3), "D", addrubricquery.getAnswerD()));

                /**
                 * 将上边的形成的以逗号隔开的型如 A,B,C,D 的list
                 * 以逗号截取开然后形成一个 String 数组 cccc
                 */
                String[] cccc = list.toString().split(",");

                /**
                 * 将list遍历 然后拿 cccc中的项 与 answers项的 optiones 也就是ABCD进行比较,
                 * 如果相等 将answers 中的这一项取出来,以逗号分隔,形成一个 形如  UUID,UUID,UUID
                 * 的新的正确答案的字符串
                 * id
                 */
                for (int p = 0; p < cccc.length; p++) {
                    for (int q = 0; q < answers.size(); q++) {
                        if (cccc[p].equals(answers.get(q).getOptiones())) {
                            answerid.append(answers.get(q).getId() + ",");
                        }
                    }

                }

                answerid.delete(answerid.length() - 1, answerid.length());
                System.out.println(answerid);


                /* String answeridlist = addrubricquery.getAnswerid();*/
                /*获取字符串*/
                /*for (int k = 0; k < answeridlist.length(); k++) {
                    for (int j = 0; j < answers.size(); j++) {
                        if (answeridlist.charAt(k) == answers.get(j).getOptiones().charAt(0)) {
                            answerid.append(answers.get(j).getId() + ",");
                        }
                    }
                }*/
                /*answerid.delete(answerid.length() - 1, answerid.length());*/


                Examrubric rubric = new Examrubric(idlist.get(4), null, addrubricquery.getCourse(), answerid.toString(), addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                Examrubric rubric1 = examrubricdao.save(rubric);

                for (int k = 0; k < answers.size(); k++) {
                    answers.get(k).setExamrubric(rubric1);
                    examanswerdao.save(answers.get(k));
                }
                return new Result(true, "添加多选成功", null);


            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "添加多选失败", null);

            }
        } else if (addrubricquery.getRubrictype().equals("填空题")) {
            System.out.println("这是填空题");
            try {
                /*新增填空题*/
                Examrubric rubric = new Examrubric(UUIDUtils.getUUID(), null, addrubricquery.getCourse(), addrubricquery.getAnswerid(), addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                examrubricdao.save(rubric);
                return new Result(true, "新增填空题成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "新增填空题失败", null);
            }
        } else {

            System.out.println("这是判断题");
            try {
                String answerid = "";
                if (addrubricquery.getAnswerid().equals("true")) {
                    answerid = "正确";
                } else if (addrubricquery.getAnswerid().equals("false")) {
                    answerid = "错误";
                }

                Examrubric rubric = new Examrubric(UUIDUtils.getUUID(), null, addrubricquery.getCourse(), answerid, addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                examrubricdao.save(rubric);
                return new Result(true, "新增判断题到考试题库成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(true, "新增判断题到考试题库失败", null);

            }

        }

    }

    /**
     * 新增考试题干(新增考试题(仅对新增多选单选))
     */
    @Override
    public Result addexamrubricjudegepack(AddrubricQuery addrubricquery) {


        if (addrubricquery.getRubrictype().equals("单选题")) {
            System.out.println(addrubricquery);
            String id = "";

            List<String> idlist = new ArrayList<>();
            //生成五个UUId
            for (int i = 0; i <= 4; i++) {
                idlist.add(UUIDUtils.getUUID());
            }

            List<Examanswer> answers = new ArrayList<>();
            answers.add(new Examanswer(idlist.get(0), "A", addrubricquery.getAnswerA()));
            answers.add(new Examanswer(idlist.get(1), "B", addrubricquery.getAnswerB()));
            answers.add(new Examanswer(idlist.get(2), "C", addrubricquery.getAnswerC()));
            answers.add(new Examanswer(idlist.get(3), "D", addrubricquery.getAnswerD()));

            for (int j = 0; j < answers.size(); j++) {
                if (addrubricquery.getAnswerid().equals(answers.get(j).getOptiones())) {
                    id = answers.get(j).getId();
                }
            }
            System.out.println("单选答案id*******************" + id);
            try {
                Examrubric rubric = new Examrubric(idlist.get(4), null, addrubricquery.getCourse(), id, addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());

                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                Examrubric rubric1 = examrubricdao.save(rubric);


                for (int k = 0; k < answers.size(); k++) {
                    answers.get(k).setExamrubric(rubric1);
                    examanswerdao.save(answers.get(k));
                }
                return new Result(true, "添加成功", null);

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "添加失败", null);
            }
            /**
             * 多项选择的处理
             */
        } else {

            System.out.println("多选添加数据******************" + addrubricquery);


            try {
                /**
                 * 声明一个StringBuilder类型的变量,
                 * 用来存储将id以逗号分隔连起来的字符串 就是这样 UUID,UUID
                 */
                StringBuilder answerid = new StringBuilder();


                List<String> idlist = new ArrayList<>();
                //生成五个UUId
                for (int i = 0; i <= 4; i++) {
                    idlist.add(UUIDUtils.getUUID());
                }


                List<Examanswer> answers = new ArrayList<>();
                answers.add(new Examanswer(idlist.get(0), "A", addrubricquery.getAnswerA()));
                answers.add(new Examanswer(idlist.get(1), "B", addrubricquery.getAnswerB()));
                answers.add(new Examanswer(idlist.get(2), "C", addrubricquery.getAnswerC()));
                answers.add(new Examanswer(idlist.get(3), "D", addrubricquery.getAnswerD()));

                /**
                 * 将上边的形成的以逗号隔开的型如 A,B,C,D 的list
                 * 以逗号截取开然后形成一个 String 数组 cccc
                 */
                /* String[] cccc = addrubricquery.getAnswerid().split(",");*/


                /**
                 * 将list遍历 然后拿 cccc中的项 与 answers项的 optiones 也就是ABCD进行比较,
                 * 如果相等 将answers 中的这一项取出来,以逗号分隔,形成一个 形如  UUID,UUID,UUID
                 * 的新的正确答案的字符串
                 * id
                 */
                String cccc = addrubricquery.getAnswerid();

                System.out.println("前台传来的答案的长度***************" + cccc.length() + "答案是**************" + cccc);
                for (int p = 0; p < cccc.length(); p++) {
                    for (int q = 0; q < answers.size(); q++) {
                        if (cccc.charAt(p) == answers.get(q).getOptiones().charAt(0)) {
                            answerid.append(answers.get(q).getId() + ",");
                        }
                    }

                }

                System.out.println("存入数据库中的id*****************" + answerid);
                answerid.delete(answerid.length() - 1, answerid.length());


                Examrubric rubric = new Examrubric(idlist.get(4), null, addrubricquery.getCourse(), answerid.toString(), addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
                rubric.setExamparper(examparperdao.findById(addrubricquery.getParperid()).get());
                Examrubric rubric1 = examrubricdao.save(rubric);

                for (int k = 0; k < answers.size(); k++) {
                    answers.get(k).setExamrubric(rubric1);
                    examanswerdao.save(answers.get(k));
                }
                return new Result(true, "添加多选成功", null);


            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "添加多选失败", null);

            }
        }
    }

    /**
     * 考试试题的删除
     */
    @Override
    public Object deleteexamrubric(String examrubricid) {


        Examrubric examrubric = examrubricdao.findById(examrubricid).get();
        Integer r = examrubricdao.deletforexamrubricid(examrubricid);
        if (r > 0) {
            return new Result(true, "移除试题成功", null);
        } else {
            return new Result(false, "移除试题失败", null);

        }

    }

    /**
     * 创建试卷的时候触发
     *
     * @param parperid
     * @return
     */
    @Override
    public Result createparper(String parperid) {

        //第一步 根据parperid查询出parper信息
        Examparper examparper = examparperdao.findById(parperid).get();


        //第二步 根据parperid查询出所有parper中所有的试题
        RubricQuery rubricquery = new RubricQuery();
        rubricquery.setExamparper(parperid);
        List<Examrubric> examrubricslist = this.getExamrubricforparperid(rubricquery);

        int dannum = 0;
        int duonum = 0;
        int packnum = 0;
        int judgenum = 0;
        for (int i = 0; i < examrubricslist.size(); i++) {
            if (examrubricslist.get(i).getRubricttype().equals("单选题")) {
                dannum++;
            }
            if (examrubricslist.get(i).getRubricttype().equals("多选题")) {
                duonum++;
            }
            if (examrubricslist.get(i).getRubricttype().equals("填空题")) {
                packnum++;
            }
            if (examrubricslist.get(i).getRubricttype().equals("判断题")) {
                judgenum++;
            }
        }
        System.out.println("填空数量*********************" + packnum);
        System.out.println("判断数量*********************" + judgenum);
        System.out.println("单选数量*********************" + dannum);
        System.out.println("多选数量*********************" + duonum);
        examparper.setFillnum(packnum);
        examparper.setJudgenum(judgenum);
        examparper.setRadionum(dannum);
        examparper.setMultiplenum(duonum);
        examparper.setNum(packnum + judgenum + dannum + duonum);

        try {
            examparperdao.save(examparper);
            return new Result(true, "创建成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "创建失败", null);
        }


    }

    /**
     * 点击开始考试按钮
     */
    @Override
    public Result beginexam(BeginexamQuery beginexamQuery) throws ParseException {

        /**
         * 取出前端传来的时间
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begintime = beginexamQuery.getBegintime();
        //转换成int类型
        long beginint = begintime.getTime();
        //加上考试时长生成一个考试结束时间的int
        long examendtimeint = beginint + beginexamQuery.getExamtime() * 60 * 1000;


        /**
         * 用考试结束时间与当前时间相比较
         */
        Date presenttime = df.parse(df.format(new Date()));
        long presenttimeint = presenttime.getTime();

        /**
         * 计算考试结束时间与当前时间的差值
         */
        long difference = (examendtimeint - presenttimeint) / 1000;

        if (difference > 0) {
            //说明在考试期间内
            if (difference > beginexamQuery.getExamtime() * 60) {
                //考试还没开始0

                return new Result(false, "考试还没开始", null);
            } else {
                return new Result(true, "考试开始了", null);
            }

        } else if (difference < 0) {
            //说明考试结束
            return new Result(false, "考试结束了", null);
        } else {
            return new Result(false, "不能进入", null);
        }
    }

    /**
     * 根据试卷id查询考试题目
     *
     * @return
     */
    @Override
    public QueryExamRubricFan queryexamrubric(RubricQuery rubricQuery) throws ParseException {

        /**
         * 取出前端传来的时间
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Examparper examparper = examparperdao.findById(rubricQuery.getExamparper()).orElse(null);

        Date begintime = examparper.getExamtime();
        //转换成int类型
        long beginint = begintime.getTime();
        //加上考试时长生成一个考试结束时间的int
        long examendtimeint = beginint + examparper.getDuration() * 60 * 1000;
        /*System.out.println("考试结束时间**********" + examendtimeint);*/
        /**
         * 用考试结束时间与当前时间相比较
         */
        Date presenttime = df.parse(df.format(new Date()));
        long presenttimeint = presenttime.getTime();
        /*System.out.println("当前时间*****************" + presenttimeint);*/
        /**
         * 计算考试结束时间与当前时间的差值(剩余的时间)
         */
        long difference = (examendtimeint - presenttimeint) / 1000;
        /*System.out.println("差值************" + difference);*/
        /**
         * 倒计时时间
         *
         */
        long downtime = difference / 60;

        /*String downtime = SecondformDate.change(difference);*/
        /*System.out.println("插值转换成时间***************" + downtime);*/
        List<Examrubric> examrubricList = examrubricdao.findAll(this.getWhereClause(rubricQuery));

        List<Examrubric> radiorubricList = new ArrayList<>();
        List<Examrubric> duorubricList = new ArrayList<>();
        List<Examrubric> packrubricList = new ArrayList<>();
        List<Examrubric> judgerubricList = new ArrayList<>();

        for (int i = 0; i < examrubricList.size(); i++) {
            examrubricList.get(i).setAnswerId(null);
            if (examrubricList.get(i).getRubricttype().equals("单选题")) {
                Examrubric radiorubric = new Examrubric();
                radiorubricList.add(examrubricList.get(i));
            }
            if (examrubricList.get(i).getRubricttype().equals("多选题")) {
                Examrubric duorubric = new Examrubric();
                duorubricList.add(examrubricList.get(i));
            }
            if (examrubricList.get(i).getRubricttype().equals("填空题")) {
                Examrubric packrubric = new Examrubric();
                packrubricList.add(examrubricList.get(i));
            }
            if (examrubricList.get(i).getRubricttype().equals("判断题")) {
                Examrubric judgerubric = new Examrubric();
                judgerubricList.add(examrubricList.get(i));
            }
        }
        /**
         * 卷子的信息
         */
        Examparper examparper1 = examparperdao.findById(rubricQuery.getExamparper()).get();


        return new QueryExamRubricFan(radiorubricList, duorubricList, packrubricList, judgerubricList, downtime, examparper1);
    }

    /**
     * 考试做题记录成绩记录表中
     */
    @Override
    public Object examend(ExamUltimately examUltimately) {

        Examrubric examrubricbig = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);

        System.out.println("试题类型*************" + examrubricbig.getRubricttype());

        if (examrubricbig.getRubricttype().equals("单选题") || examrubricbig.getRubricttype().equals("多选题")) {
            System.out.println("单选或者多选");
            /**
             * 根据考试题干id查询本条做题记录
             */
            Studentexamlog studentexamloger = studentexamlogdao.selectlogforexamrubricid(examUltimately.getExamrubricId());

            /**
             * 判断根据考试题干查询的考试记录是否为空
             */
            if (studentexamloger == null) {
                System.out.println("记录表中为空**************");

                try {
                    String Id = UUIDUtils.getUUID();

                    /**
                     * (根据考试试卷id将试卷的所有试题查询出来,
                     *  从中单独取出来试题的题干中的答案id[answerId],
                     *  遍历该id集合,使之与学生所选的答案id比较.
                     *  在根据答案id的外键关系可以获取到考试试卷的id,
                     *  再根据考试试卷id,对试题进行加分.)
                     */
                    RubricQuery rubricQuery = new RubricQuery();
                    rubricQuery.setExamparper(examUltimately.getExamparperId());
                    List<Examrubric> examrubricList = this.getExamrubricforparperid(rubricQuery);
                    List<String> answerlist = new ArrayList<>();

                    int score = 0;
                    if (examrubricbig.getRubricttype().equals("单选题")) {

                        Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                        if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
                            score = examUltimately.getScore();
                        } else {
                            score = 0;

                        }
                    } else {
                        Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                        String[] answerid = examrubric.getAnswerId().split(",");
                        String[] answerider = examUltimately.getSelectanswerId().split(",");

                        if (Arrays.equals(answerid, answerider)) {
                            score = examUltimately.getScore();
                        } else {
                            score = 0;

                        }
                    }

                    /**
                     * 声明一个新下考试记录对象
                     */
                    Studentexamlog studentexamlog = new Studentexamlog();
                    studentexamlog.setId(Id);
                    studentexamlog.setExamrubricId(examUltimately.getExamrubricId());
                    studentexamlog.setExamparperId(examUltimately.getExamparperId());
                    studentexamlog.setSelectId(examUltimately.getSelectanswerId());
                    studentexamlog.setStudentId(examUltimately.getStudentId());
                    studentexamlog.setPerformance(score);
                    studentexamlogdao.save(studentexamlog);
                    return new Result(true, "记录成功", null);

                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result(false, "记录失败", null);
                }

            } else {
                /**
                 * 记录中有这条做题记录的情况
                 * (1)先取出本条考试记录  studentexamlogerdsa
                 * (2)再将前端传来的所选的答案id
                 *
                 */
                System.out.println("记录表中步步为空**************");
                try {
                    RubricQuery rubricQuery = new RubricQuery();
                    rubricQuery.setExamparper(examUltimately.getExamparperId());
                    List<Examrubric> examrubricList = this.getExamrubricforparperid(rubricQuery);

                    List<String> answerid = new ArrayList<>();
                    for (int k = 0; k < examrubricList.size(); k++) {
                        String answer = examrubricList.get(k).getAnswerId();
                        answerid.add(answer);
                    }


                    int score = 0;

                    if (examrubricbig.getRubricttype().equals("单选题")) {


                        Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                        if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
                            score = examUltimately.getScore();
                        } else {
                            score = 0;

                        }
                    } else {
                        Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                        String[] answeridsan = examrubric.getAnswerId().split(",");
                        String[] answeridsi = examUltimately.getSelectanswerId().split(",");

                        if (Arrays.equals(answeridsan, answeridsi)) {
                            score = examUltimately.getScore();
                        } else {
                            score = 0;

                        }
                    }

                    studentexamloger.setSelectId(examUltimately.getSelectanswerId());
                    studentexamloger.setPerformance(score);
                    studentexamlogdao.save(studentexamloger);

                    return new Result(true, "修改记录成功", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result(false, "修改记录失败", null);
                }


            }
        } else {
            /**
             * 填空题,判断题的处理方式
             */
            try {


                Integer score = 0;
                String Id = UUIDUtils.getUUID();
                Studentexamlog studentexamloger = studentexamlogdao.selectlogforexamrubricid(examUltimately.getExamrubricId());
                if (studentexamloger == null) {

                    Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                    if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
                        score = examrubric.getScore();
                    } else {
                        score = 0;
                    }
                    Studentexamlog studentexamlog = new Studentexamlog();
                    studentexamlog.setId(Id);
                    studentexamlog.setExamparperId(examUltimately.getExamparperId());
                    studentexamlog.setExamrubricId(examUltimately.getExamrubricId());
                    studentexamlog.setSelectId(examUltimately.getSelectanswerId());
                    studentexamlog.setStudentId(examUltimately.getStudentId());
                    studentexamlog.setPerformance(score);
                    studentexamlogdao.save(studentexamlog);
                } else {

                    Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
                    if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
                        score = examrubric.getScore();
                    } else {
                        score = 0;
                    }
                    studentexamloger.setPerformance(score);
                    studentexamloger.setSelectId(examUltimately.getSelectanswerId());
                    studentexamlogdao.save(studentexamloger);
                }
                return new Result(true, "修改记录成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改记录失败", null);
            }
        }
    }

    /**
     * 整个试卷做完之后点击交卷时候
     */
    @Override
    public Object examination(ExamUltimately examUltimately) throws ParseException {

        Examparper examparper = examparperdao.findById(examUltimately.getExamparperId()).orElse(null);

        /**
         * 获取开考时间,以及最短交卷时间
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date begintime = examparper.getExamtime();//开考时间
        long shotendtimeint = begintime.getTime() + examparper.getExamshortesttime() * 60 * 1000;

        Date presenttime = df.parse(df.format(new Date()));
        long presenttimeint = presenttime.getTime();


        if (presenttimeint - shotendtimeint > 0) {


            try {
                String Id = UUIDUtils.getUUID();
                Integer total = 0;
                Performance performance = new Performance();

                /**
                 * 查询出考试记录中当前试卷的所有的考试记录
                 */
                List<Studentexamlog> studentexamlogs = studentexamlogdao.selecttotalforparperid(examUltimately.getExamparperId());

                for (int i = 0; i < studentexamlogs.size(); i++) {
                    total += studentexamlogs.get(i).getPerformance();
                }
                performance.setId(Id);
                performance.setParperId(examUltimately.getExamparperId());
                performance.setStudentId(examUltimately.getStudentId());
                performance.setTotal(total);
                /**
                 * 记录考试总成绩
                 */
                performancedao.save(performance);
                return new Result(true, "成绩记录成功,总分" + total, null);

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "成绩记录失败", null);
            }

        } else {
            return new Result(false, "现在还不能交卷哦,少年!!", null);
        }

    }


    /**
     * 查看考试试卷(做完的考试试卷)
     * (1)首先查看考过这张试卷的学生
     * (2)点击每个学生的时候显示学生所作的卷子中学生所选的答案以及正确答案
     */


}
