package com.ysd.iep.dao;

import com.ysd.iep.entity.po.DepartmentDB;
import com.ysd.iep.entity.po.PermissionDB;
import com.ysd.iep.entity.vo.PermissionChildrenVo;
import com.ysd.iep.entity.vo.PermissionVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface PermissionDao extends BaseDao<PermissionDB, String> {

    @Query(value = "select new com.ysd.iep.entity.vo.PermissionVo(typeName)  from PermissionDB group by typeName")
    List<PermissionVo> findTypeAll();

    @Query("from PermissionDB where typeName=:typeName")
    List<PermissionDB> getChidlren(@Param("typeName") String typeName);

    @Query(value = "select permissionId from rolepermission where roleId =:roleId",nativeQuery = true)
    List<String> findByRoleId(@Param("roleId")String roleId);

}
