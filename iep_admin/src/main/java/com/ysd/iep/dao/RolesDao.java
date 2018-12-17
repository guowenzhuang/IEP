package com.ysd.iep.dao;

import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    @Query(value = "SELECT * from roles where id in (select roleid from userroles where userid=:uuid) and status=0",nativeQuery = true)
    List<RolesDB> findByUserId(String uuid);

    /**
     * 根据角色名称查询不属于的角色
     * @param names
     * @return
     */
    @Query("from RolesDB where name not in(:names) and  status=0")
    List<RolesDB> findByNameNotIn(List<String> names);

    /**
     * 移除角色关系
     * @param roleId
     */
    @Modifying
    @Query(value = "delete from rolemodules where RoleId=:roleId",nativeQuery = true)
    void deleteModuleByRolesId(@Param("roleId") String roleId);

    /**
     * 新增角色模块关系
     * @param roleId
     * @param moduleId
     */
    @Modifying
    @Query(value = "insert into rolemodules (RoleId, ModuleId) values (:roleId,:moduleId);",nativeQuery = true)
    void insertModule(@Param("roleId") String roleId,@Param("moduleId")String moduleId);

    /**
     * 删除角色
     * @param uuid 角色id
     */
    @Modifying
    @Query(value = "update roles set `status`=1 where id=:uuid",nativeQuery = true)
    void deleteStatus(@Param("uuid") String uuid);

}
