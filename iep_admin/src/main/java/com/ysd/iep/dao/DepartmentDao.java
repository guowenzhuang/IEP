package com.ysd.iep.dao;

import com.ysd.iep.entity.po.DepartmentDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface DepartmentDao extends BaseDao<DepartmentDB,String> {

    @Query(value = "select departmentId,name,weight from department order by weight desc  limit 0,:rows",nativeQuery = true)
    List<DepartmentDB> findOrderWeightTop7(@Param("rows") Integer rows);

    @Query(value = "select departmentId,name,weight from department order by weight desc",nativeQuery = true)
    List<DepartmentDB> findOrderWeight();
}
