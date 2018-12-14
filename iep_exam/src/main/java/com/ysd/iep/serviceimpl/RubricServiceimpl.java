package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.AnswerDao;
import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Answer;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.entity.parameter.UpdaterubricQuery;
import com.ysd.iep.service.RubricService;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import javax.persistence.criteria.Expression;

import java.util.ArrayList;
import java.util.List;


@Service
public class RubricServiceimpl implements RubricService {
    @Autowired
    RubricDao rubricdao;
    @Autowired
    AnswerDao answerdao;


    /**
     * 多条件分页查询
     *
     * @param rubricquery
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Page<Rubric> queryUserByuserQuery(RubricQuery rubricquery, Integer page, Integer rows) {
        Pageable pageable = new PageRequest(page - 1, rows);
        return rubricdao.findAll(this.getWhereClause(rubricquery), pageable);
    }

    /**
     * 删除试题
     *
     * @param id
     * @return
     */
    @Override
    public Object deleteredicbyid(String id) {
        try {
            rubricdao.deleteById(id);
            return new Result(true, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败", null);
        }
    }

    /**
     * 修改试题(三种试题)
     *
     * @param updaterubricquery
     * @return
     */
    @Override
    public Object updateredicbyid(UpdaterubricQuery updaterubricquery) {

        /**
         *修改选择题
         */

        if (updaterubricquery.getType().equals("选择题")) {
            String id = "";


            System.out.println("*********************修改选择");
            System.out.println(updaterubricquery);
            try {
                //根据id查询题干
                Rubric rubric = rubricdao.findById(updaterubricquery.getId()).get();

                String idtype = updaterubricquery.getXzanswer();
                if (idtype.equals("A")) {
                    id = updaterubricquery.getAid();
                }
                if (idtype.equals("B")) {
                    id = updaterubricquery.getBid();
                }
                if (idtype.equals("C")) {
                    id = updaterubricquery.getCid();
                }
                if (idtype.equals("D")) {

                    id = updaterubricquery.getDid();
                }
                //赋值题干
                rubric.setContent(updaterubricquery.getRubric());
                rubric.setAnswer(null);
                rubric.setAnswerId(id);
                System.out.println(rubric);
                Rubric rubric1 = rubricdao.save(rubric);


                List<Answer> answers = new ArrayList<>();
                answers.add(new Answer(updaterubricquery.getAid(), "A", updaterubricquery.getAnswerA(), rubric1));
                answers.add(new Answer(updaterubricquery.getBid(), "B", updaterubricquery.getAnswerB(), rubric1));
                answers.add(new Answer(updaterubricquery.getCid(), "C", updaterubricquery.getAnswerC(), rubric1));
                answers.add(new Answer(updaterubricquery.getDid(), "D", updaterubricquery.getAnswerD(), rubric1));
                for (int i = 0; i < answers.size(); i++) {
                    answerdao.save(answers.get(i));
                }
                return new Result(true, "修改选择题成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改选择题失败", null);
            }

        }

        /**
         * 填空题修改
         */
        if (updaterubricquery.getType().equals("填空题")) {
            System.out.println("*********************修改填空");
            System.out.println(updaterubricquery);
            try {
                Rubric rubric = rubricdao.findById(updaterubricquery.getId()).get();
                rubric.setContent(updaterubricquery.getRubric());//修改填空题的题干
                rubric.setAnswerId(updaterubricquery.getTkanswer());//修改填空题的答案
                rubricdao.save(rubric);
                return new Result(true, "修改填空题成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改填空题失败", null);
            }
        }
        /**
         *修改判断题
         */
        if (updaterubricquery.getType().equals("判断题")) {
            System.out.println("*********************修改判断");
            System.out.println(updaterubricquery);
            try {
                Rubric rubric = rubricdao.findById(updaterubricquery.getId()).get();
                String answer = null;
                if (updaterubricquery.getPdanswer().equals("true")) {
                    answer = "正确";
                } else if (updaterubricquery.getPdanswer().equals("false")) {
                    answer = "错误";
                }
                rubric.setAnswerId(answer);
                rubricdao.save(rubric);
                return new Result(true, "修改判断题成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改判断题失败", null);
            }
        }


        return null;
    }

    /**
     * 新增试题
     *
     * @param addrubricquery
     * @return
     */
    @Override
    public Object addrubric(AddrubricQuery addrubricquery) {
        if (addrubricquery.getRubrictype().equals("选择题")) {
            String answerid = null;
            List<String> idlist = new ArrayList<>();
            //生成五个UUId
            for (int i = 0; i <= 4; i++) {
                idlist.add(UUIDUtils.getUUID());
            }

            List<Answer> answers = new ArrayList<>();
            answers.add(new Answer(idlist.get(0), "A", addrubricquery.getAnswerA()));
            answers.add(new Answer(idlist.get(1), "B", addrubricquery.getAnswerB()));
            answers.add(new Answer(idlist.get(2), "C", addrubricquery.getAnswerC()));
            answers.add(new Answer(idlist.get(3), "D", addrubricquery.getAnswerD()));
            try {

                for (int j = 0; j < answers.size(); j++) {
                    if (addrubricquery.getAnswerid().equals(answers.get(j).getOptiones())) {
                        answerid = answers.get(j).getId();
                    }
                }
                Rubric rubric = new Rubric(idlist.get(4), null, null, answerid, addrubricquery.getAddrubric(), null, null, addrubricquery.getRubrictype());
                Rubric rubric1 = rubricdao.save(rubric);

                for (int k = 0; k < answers.size(); k++) {
                    answers.get(k).setRubric(rubric1);
                    answerdao.save(answers.get(k));
                }
                return new Result(true, "添加成功", null);

            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "添加失败", null);
            }
        } else if (addrubricquery.getRubrictype().equals("填空题")) {
            try {
                /*新增填空题*/
                Rubric rubric = new Rubric(UUIDUtils.getUUID(), null, null, addrubricquery.getAnswerid(), addrubricquery.getAddrubric(), null, null, addrubricquery.getRubrictype(), null);
                rubricdao.save(rubric);
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

                Rubric rubric = new Rubric(UUIDUtils.getUUID(), null, null, answerid, addrubricquery.getAddrubric(), null, null, addrubricquery.getRubrictype(), null);
                rubricdao.save(rubric);
                return new Result(true, "新增判断题成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(true, "新增判断题失败", null);

            }

        }


    }


    /**
     * 多条件查询(where条件拼接)
     *
     * @param rubricquery
     * @return
     */
    private Specification<Rubric> getWhereClause(final RubricQuery rubricquery) {
        return new Specification<Rubric>() {

            @Override
            public Predicate toPredicate(Root<Rubric> root, CriteriaQuery<?> query, CriteriaBuilder
                    cb) {
                Predicate predicate = cb.conjunction();//动态SQL表达式
                List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合

                if (rubricquery.getRubric() != null && !"".equals(rubricquery.getRubric())) {
                    exList.add(cb.like(root.get("content"), "%" + rubricquery.getRubric() + "%"));

                }
                if (rubricquery.getType() != null && !"".equals(rubricquery.getType())) {
                    exList.add(cb.equal(root.get("rubricttype").as(String.class), rubricquery.getType()));

                }
                if (rubricquery.getSection() != null && !"".equals(rubricquery.getSection())) {
                    exList.add(cb.equal(root.get("sectionId").as(String.class), rubricquery.getSection()));

                }
                if (rubricquery.getCourse() != null && !"".equals(rubricquery.getCourse())) {
                    exList.add(cb.equal(root.get("courseId").as(String.class), rubricquery.getCourse()));

                }

                return predicate;
            }
        };
    }


}



