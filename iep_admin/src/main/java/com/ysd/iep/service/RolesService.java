package com.ysd.iep.service;

import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.vo.RolesVo;
import com.ysd.iep.entity.vo.UserRoleVo;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class RolesService {
    @Autowired
    private RolesDao rolesDB;

    /**
     * 查询属于用户的角色和不属于用户的角色
     * @param uuid
     * @return
     */
    public Result queryUnAndNoqueryUn(String uuid) {
        List<RolesDB> beLogedRoles = rolesDB.findByUserId(uuid);
        List<String> names = beLogedRoles.stream().map(RolesDB::getName).collect(Collectors.toList());
        List<RolesDB> noBeLogedRoles = rolesDB.findByNameNotIn(names);
        List<RolesVo> beLogedRolesVo = BeanConverterUtil.copyList(beLogedRoles, RolesVo.class);
        List<RolesVo> noBeLogedRolesVo = BeanConverterUtil.copyList(noBeLogedRoles, RolesVo.class);
        UserRoleVo userRoleVo = new UserRoleVo()
                .setUserRole(beLogedRolesVo)
                .setUserNoRole(noBeLogedRolesVo);
        return new Result(true, userRoleVo);
    }
}
