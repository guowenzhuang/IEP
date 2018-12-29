package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.SectionexamrubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.service.SectionrubricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author gaohzongye
 * @date 2018/12/29
 * 章节测试Service 实现类
 */
@Service
public class SectionrubricServiceimpl implements SectionrubricService {
    @Autowired
    SectionexamrubricDao sectionexamrubricdao;

    /**
     * 多条件分页查询章节测试试题
     *
     * @param rubricquery
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Page<Sectionexamrubric> queryUserByuserQuery(RubricQuery rubricquery, Integer page, Integer rows) {
        Pageable pageable = new PageRequest(page - 1, rows);
        return sectionexamrubricdao.findAll(this.getWhereClause(rubricquery), pageable);
    }

    /**
     * 多条件查询(where条件拼接)
     *
     * @param rubricquery
     * @return
     */
    private Specification<Sectionexamrubric> getWhereClause(final RubricQuery rubricquery) {
        return new Specification<Sectionexamrubric>() {

            @Override
            public Predicate toPredicate(Root<Sectionexamrubric> root, CriteriaQuery<?> query, CriteriaBuilder
                    cb) {
                Predicate predicate = cb.conjunction();//动态SQL表达式
                List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合


                if (rubricquery.getCoursetype() != null && !"".equals(rubricquery.getCoursetype())) {
                    exList.add(cb.equal(root.get("courseId").as(Integer.class), rubricquery.getCoursetype()));

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
