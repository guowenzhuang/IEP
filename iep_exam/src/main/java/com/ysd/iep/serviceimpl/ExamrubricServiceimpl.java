package com.ysd.iep.serviceimpl;


import com.ysd.iep.dao.ExamanswerDao;
import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.entity.*;
import com.ysd.iep.entity.parameter.ABCD;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.service.ExamrubricService;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
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
    private Specification<Examrubric> getWhereClause(final RubricQuery rubricquery) {
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
                if (addrubricquery.getAnswerid().equals(ABCD.get(j))) {
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
            try {
                String answerid = "";
                if (addrubricquery.getAnswerid().equals("true")) {
                    answerid = "正确";
                } else if (addrubricquery.getAnswerid().equals("false")) {
                    answerid = "错误";
                }

                Examrubric rubric = new Examrubric(UUIDUtils.getUUID(), null, addrubricquery.getCourse(), addrubricquery.getAnswerid(), addrubricquery.getAddrubric(), addrubricquery.getUserid(), addrubricquery.getScore(), addrubricquery.getRubrictype());
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


}
