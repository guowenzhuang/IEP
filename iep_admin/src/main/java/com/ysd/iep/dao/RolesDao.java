package com.ysd.iep.dao;

import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface RolesDao extends BaseDao<RolesDB,String> {
    /**
     * 根据用户id查询属于用户的id
     * @param uuid
     * @return
     */
    @Query(value = "SELECT * from roles where id in (select roleid from userroles where userid=:uuid)",nativeQuery = true)
    List<RolesDB> findByUserId(String uuid);

    /**
     * 根据角色名称查询不属于的角色
     * @param names
     * @return
     */
    List<RolesDB> findByNameNotIn(List<String> names);

}
