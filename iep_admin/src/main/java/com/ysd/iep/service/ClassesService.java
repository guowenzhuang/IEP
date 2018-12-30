package com.ysd.iep.service;

import com.ysd.iep.dao.ClassesDao;
import com.ysd.iep.entity.po.ClassesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.query.ClassQuery;
import com.ysd.iep.entity.vo.ClassVo;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class ClassesService {
    @Autowired
    private ClassesDao classesDao;

    public PagingResult<ClassVo> query(ClassQuery classQuery) {
        Specification<ClassesDB> specification = new Specification<ClassesDB>() {
            @Override
            public Predicate toPredicate(Root<ClassesDB> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                if (EmptyUtil.stringE(classQuery.getCode())) {
                    Path<String> codePath = root.get("code");
                    predicates.add(criteriaBuilder.like(codePath, "%" + classQuery.getCode() + "%"));
                }
                if (EmptyUtil.stringE(classQuery.getDepartmentId())) {
                    Path<String> departmentIdath = root.get("departmentDB").get("departmentId");
                    predicates.add(criteriaBuilder.equal(departmentIdath,  classQuery.getDepartmentId()));
                }
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        };

        Pageable pageable = PageRequest.of(classQuery.getPage() - 1, classQuery.getRows());
        Page<ClassesDB> classesDBPage = classesDao.findAll(specification, pageable);
        List classVos= BeanConverterUtil.copyList(classesDBPage.getContent(),ClassVo.class, (item,target) ->{
            ClassesDB classesDB= (ClassesDB) item;
            ClassVo classVo= (ClassVo) target;
            classVo.setDepartName(classesDB.getDepartmentDB().getName());
            classVo.setDepartId(classesDB.getDepartmentDB().getDepartmentId());
            return null;
        });
        PagingResult<ClassVo> classesDBPagingResult=new PagingResult<>();
        classesDBPagingResult.setTotal(classesDBPage.getTotalElements());
        classesDBPagingResult.setRows(classVos);
        return classesDBPagingResult;
    }

    @Transactional(rollbackOn = Exception.class)
    public void add(ClassesDB classesDB) throws DataIntegrityViolationException {
        ClassesDB byCode = classesDao.findByCode(classesDB.getCode());
        if(byCode!=null){
            throw new DataIntegrityViolationException("编号重复");
        }
        classesDao.save(classesDB);
    }

    public void update(ClassesDB classesDB) throws DataIntegrityViolationException {
        ClassesDB byCode = classesDao.findByCode(classesDB.getCode());
        if(byCode!=null && !(byCode.getCode().equals(classesDB.getCode()))){
            throw new DataIntegrityViolationException("编号重复");
        }
        classesDao.save(classesDB);
    }

    public void delete(String id) {
        classesDao.deleteById(id);
    }
}
