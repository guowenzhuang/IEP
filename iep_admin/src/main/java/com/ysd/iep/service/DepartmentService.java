package com.ysd.iep.service;

import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.dao.DepartmentDao;
import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.po.DepartmentDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.query.DepartmentQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.UsersVo;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
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
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@PermissionType("院系")
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询前几个
     *
     * @return
     */
    public List<DepartmentDTO> departmentTop7() {
        List<DepartmentDB> departmentDB = departmentDao.findOrderWeightTop7(7);
        List<DepartmentDTO> departmentDTOS = BeanConverterUtil.copyList(departmentDB, DepartmentDTO.class);
        return departmentDTOS;
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<DepartmentDTO> department() {
        List<DepartmentDB> departmentDB = departmentDao.findOrderWeight();
        List<DepartmentDTO> departmentDTOS = BeanConverterUtil.copyList(departmentDB, DepartmentDTO.class);
        return departmentDTOS;
    }

    public PagingResult<DepartmentDTO> query(DepartmentQuery departmentQuery) {
        Specification<DepartmentDB> specification = new Specification<DepartmentDB>() {
            @Override
            public Predicate toPredicate(Root<DepartmentDB> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                if (EmptyUtil.stringE(departmentQuery.getName())) {
                    Path<String> namePath = root.get("name");
                    predicates.add(criteriaBuilder.like(namePath, "%" + departmentQuery.getName() + "%"));
                }
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        };
        Pageable pageable = PageRequest.of(departmentQuery.getPage() - 1, departmentQuery.getRows());
        Page<DepartmentDB> departmentDBS = departmentDao.findAll(specification, pageable);
        List<DepartmentDB> dbsContent = departmentDBS.getContent();
        PagingResult<DepartmentDTO> pagingResult = new PagingResult<DepartmentDTO>();
        pagingResult.setRows(BeanConverterUtil.copyList(dbsContent,DepartmentDTO.class));
        pagingResult.setTotal(departmentDBS.getTotalElements());
        return pagingResult;

    }
}
