package com.ysd.iep.service;

import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.vo.RolesTransferVo;
import com.ysd.iep.entity.vo.UserRoleVo;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public UserRoleVo queryUnAndNoqueryUn(String uuid) {
        List<RolesDB> beLogedRoles = rolesDB.findByUserId(uuid);
        List<String> names = beLogedRoles.stream().map(RolesDB::getName).collect(Collectors.toList());
        List<RolesDB> roles = rolesDB.findAll();
        List<RolesTransferVo> beLogedRolesTransferVo = BeanConverterUtil.copyList(beLogedRoles, RolesTransferVo.class);
        List<RolesTransferVo> rolesTransferVos = BeanConverterUtil.copyList(roles, RolesTransferVo.class);
        UserRoleVo userRoleVo = new UserRoleVo()
                .setUserRole(beLogedRolesTransferVo)
                .setRoles(rolesTransferVos);
        return userRoleVo;
    }
}
