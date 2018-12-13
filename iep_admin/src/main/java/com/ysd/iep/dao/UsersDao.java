package com.ysd.iep.dao;

import com.ysd.iep.entity.po.UsersDB;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * 新增角色
     * @param uuid 用户id
     * @param roleId 角色id
     */
    @Modifying
    @Query(value = "insert into userroles(RoleId,UserId) values (:roleId,:uuid)",nativeQuery = true)
    void addRole(@Param("uuid") String uuid,@Param("roleId") String roleId);

    /**
     * 用户移除角色
     * @param uuid 用户id
     * @param roleId 角色id
     */
    @Modifying
    @Query(value = "delete from userroles where UserId=:uuid and RoleId=:roleId",nativeQuery = true)
    void deleteRole(@Param("uuid") String uuid,@Param("roleId") String roleId);

    /**
     * 删除用户
     * @param uuid 用户id
     */
    @Modifying
    @Query(value = "update users set `status`=1 where id=:uuid",nativeQuery = true)
    void deleteStatus(@Param("uuid") String uuid);

}
