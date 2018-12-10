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
     * 根据父级id获取子模块
     * @param parentId
     * @return
     */
    @Query(value = "select * from modules where ParentId=:parentId and Id in (select ModuleId FROM rolemodules where RoleId=(select id from roles where name=:roleName))",nativeQuery = true)
    List<ModulesDB> getByParentIdAndRolesName(@Param("parentId") Integer parentId,@Param("roleName") String roleName);
}
