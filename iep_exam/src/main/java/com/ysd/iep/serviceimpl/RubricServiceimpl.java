package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.service.RubricService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import javax.persistence.criteria.Expression;

import java.util.List;


@Service
public class RubricServiceimpl implements RubricService {
    @Autowired
    RubricDao rubricdao;


    @Override
    public List<Rubric> queryUserByuserQuery(RubricQuery rubricquery) {


        return rubricdao.findAll(this.getWhereClause(rubricquery));
    }


    private Specification<Rubric> getWhereClause(final RubricQuery rubricquery) {

        System.out.println(rubricquery);
        return new Specification<Rubric>() {

            @Override
            public Predicate toPredicate(Root<Rubric> root, CriteriaQuery<?> query, CriteriaBuilder
                    cb) {
                Predicate predicate = cb.conjunction();//动态SQL表达式
                List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合

                if (rubricquery.getRubric() != null && !"".equals(rubricquery.getRubric())) {
                    exList.add(cb.like(root.get("Content"), "%" + rubricquery.getRubric() + "%"));

                }
                if (rubricquery.getType() != null && !"".equals(rubricquery.getType())) {
                    exList.add(cb.equal(root.get("Rubricttype").as(String.class), rubricquery.getType()));

                }
                if (rubricquery.getSection() != null && !"".equals(rubricquery.getSection())) {
                    exList.add(cb.equal(root.get("SectionId").as(String.class), rubricquery.getSection()));
                  
                }
                if (rubricquery.getCourse() != null && !"".equals(rubricquery.getCourse())) {
                    exList.add(cb.equal(root.get("CourseId").as(String.class), rubricquery.getCourse()));

                }

                return predicate;
            }
        };
    }


}



