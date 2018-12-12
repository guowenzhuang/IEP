package com.ysd.iep.dao;

import com.ysd.iep.entity.po.ModulesDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface ModulesDao extends BaseDao<ModulesDB,Integer> {
    /**
     * 根据父级id和角色名称获取模块
     * @param parentId 父级id
     * @return
     */
    @Query(value = "select * from modules where ParentId=:parentId and Id in (select ModuleId FROM rolemodules where RoleId=(select id from roles where name=:roleName))",nativeQuery = true)
    List<ModulesDB> getByParentIdAndRolesName(@Param("parentId") Integer parentId,@Param("roleName") String roleName);

    /**
     * 根据父级id和角色名称集合获取模块
     * @param parentId 父级id
     * @param roleNames 角色名称数组
     * @return
     */
    @Query(value = "select * from modules where ParentId=:parentId and Id in (select ModuleId FROM rolemodules where RoleId=(select id from roles where name in (:roleNames)))",nativeQuery = true)
    List<ModulesDB> getByParentIdAndRolesName(@Param("parentId") Integer parentId,@Param("roleNames") String[] roleNames);
}
