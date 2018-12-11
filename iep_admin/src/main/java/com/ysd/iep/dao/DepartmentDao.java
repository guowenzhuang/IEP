package com.ysd.iep.dao;

import com.ysd.iep.entity.po.DepartmentDB;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface DepartmentDao extends BaseDao<DepartmentDB,String> {
    List<DepartmentDB> findOrderByWeight();
}
