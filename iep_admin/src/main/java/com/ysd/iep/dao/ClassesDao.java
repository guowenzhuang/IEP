package com.ysd.iep.dao;

import com.ysd.iep.entity.po.ClassesDB;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface ClassesDao extends BaseDao<ClassesDB,String> {
    /**
     * 根据班级编码查找班级
     * @param code
     * @return
     */
    ClassesDB findByCode(String code);

    /**
     * 根据班级id查询所有班级
     * @param ids
     * @return
     */
    List<ClassesDB> findByIdIn(String[] ids);
}
