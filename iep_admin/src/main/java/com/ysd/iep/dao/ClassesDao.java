package com.ysd.iep.dao;

import com.ysd.iep.entity.po.ClassesDB;

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
}
