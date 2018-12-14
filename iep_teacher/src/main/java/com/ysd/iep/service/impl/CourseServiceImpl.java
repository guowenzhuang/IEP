package com.ysd.iep.service.impl;

import com.ysd.iep.dao.CourseRepository;
import com.ysd.iep.entity.Course;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.service.CourseService;
import com.ysd.iep.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;
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

    @Override
    public void deleteById(Integer courId) {
        coursedao.deleteById(courId);
    }

    /**
     * 
     * 前台课程显示
     */
    @Override
    public Page<Course> queryCourseDepidAllPage(String depId, Integer page, Integer size) {
    	Sort sort = new Sort(Sort.Direction.ASC, "courId"); 
	    Pageable pageable = new PageRequest(page-1, size, sort);
	     return coursedao.findByCourDepid("%"+depId+"%", pageable);

    }

    @Override
    public Result insertCourse(Course course) {
        coursedao.save(course);
        return new Result(true);
    }

    @Override
    public List<Course> findByCourseId(String courId) {
        List<Course> dd=new ArrayList<Course>();
       if (courId != null && courId != "") {
            String[] s=courId.split(",");
           int[] idss=new int[s.length];
           for (int i=0;i<s.length;i++){
                idss[i]=Integer.parseInt(s[i]);
             }
           for (Integer id : idss) {
               Course dingyi =  coursedao.findByCourseId(id);
               dd.add(dingyi);
           }

        }
                 return dd;
    }
    /**
     * 根据教师Id查询课程
     */
    @Override
    public List<Course> queryCourByteaId(String teaId) {
        List<Course> list = null;
        if (EmptyUtil.stringE(teaId)) {
            list = coursedao.findByCourTeaid(teaId);
        }
        return list;

    }



}
