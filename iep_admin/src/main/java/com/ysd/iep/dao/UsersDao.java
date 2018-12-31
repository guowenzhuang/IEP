package com.ysd.iep.dao;

import com.ysd.iep.entity.po.UsersDB;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    /**
     * 根据角色id和用户姓名 分页查询
     * @param roleId
     * @return
     */
    @Query(value = "select * from users u left join userroles u2 on u.Id = u2.UserId where u2.RoleId=:roleId and u.loginName like CONCAT('%',:name,'%')",nativeQuery = true)
    List<UsersDB> findByRole(@Param("name") String userName,@Param("roleId") String roleId);
    /**
     * 根据角色id和用户姓名 分页查询
     * @param roleId
     * @return
     */
    @Query(value = "select * from users u left join userroles u2 on u.Id = u2.UserId where u2.RoleId=:roleId",nativeQuery = true)
    List<UsersDB> findByRole(@Param("roleId") String roleId);
    /**
     * 根据角色id和用户姓名 分页查询
     * @param roleId
     * @param pageable
     * @return
     */
    @Query(value = "select * from users u left join userroles u2 on u.Id = u2.UserId where u2.RoleId=:roleId and u.loginName like CONCAT('%',:name,'%')",nativeQuery = true)
    Page<UsersDB> findByRole(@Param("name") String userName,@Param("roleId") String roleId,Pageable pageable);
    /**
     * 根据角色id和用户姓名 分页查询
     * @param roleId
     * @param pageable
     * @return
     */
    @Query(value = "select * from users u left join userroles u2 on u.Id = u2.UserId where u2.RoleId=:roleId",nativeQuery = true)
    Page<UsersDB> findByRole(@Param("roleId") String roleId,Pageable pageable);

    /**
     * 根据id修改用户信息
     * @param email
     * @param id
     * @return
     */
    @Modifying
    @Query(value = "update users set protectEMail=:email,protectMTel=:tel WHERE Id=:id",nativeQuery = true)
    void updateUserById(@Param("email")String email,@Param("tel")String tel,@Param("id")String id);

}
