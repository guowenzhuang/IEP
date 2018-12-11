package com.ysd.iep.dao;

import com.ysd.iep.entity.po.UsersDB;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface UsersDao extends BaseDao<UsersDB,String> {
    /**
     * 根据用户名查找用户
     * @param name 用户姓名
     * @return
     */
    UsersDB findTopByLoginName(String name);
}
