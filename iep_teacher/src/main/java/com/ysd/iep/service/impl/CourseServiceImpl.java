package com.ysd.iep.service.impl;

import com.ysd.iep.dao.CourseRepository;
import com.ysd.iep.entity.Course;
import com.ysd.iep.service.CourseService;
import com.ysd.iep.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
   private CourseRepository coursedao;
    @Override
    /**
     * 课程的分页查询
     */
    public Page<Course> getPaginate(int page, int pageSize, String courName) {
        Specification<Course>  specification = new Specification<Course>() {
            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                Path<String> cardNoPath = root.get("courName");
                if (EmptyUtil.stringE(courName)) {
                    predicates.add(cb.like(cardNoPath, "%" + courName + "%"));
                }
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));

            }
        };
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);

        Page<Course> c = coursedao.findAll(specification, pageRequest);
        return c;


    }
}
