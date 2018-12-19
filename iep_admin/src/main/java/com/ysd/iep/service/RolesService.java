package com.ysd.iep.service;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.query.RolesQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.RolesTransferVo;
import com.ysd.iep.entity.vo.RolesVo;
import com.ysd.iep.entity.vo.UserRoleVo;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@PermissionType("角色")
@Service
public class RolesService {
    @Autowired
    private RolesDao rolesDao;

    /**
     * 角色设置权限
     *
     * @param roleId 角色id
     * @param pids   权限id集合
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('role:setPermission')")
    @PermissionMethod("设置权限")
    public void setPermission(String roleId, String pids) {
        rolesDao.deletePermissionByRolesId(roleId);
        String[] pidsArr = pids.split(",");
        for (String pid : pidsArr) {
            if (EmptyUtil.stringE(pid)) {
                rolesDao.insertPermission(roleId, pid);
            }

        }

    }
    /**
     * 角色设置模块
     *
     * @param roleId 角色id
     * @param midS   模块id集合
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('role:setModule')")
    @PermissionMethod("设置模块")
    public void setModule(String roleId, String midS) {
        rolesDao.deleteModuleByRolesId(roleId);
        String[] midsArr = midS.split(",");
        for (String mid : midsArr) {
            if (EmptyUtil.stringE(mid)) {
                rolesDao.insertModule(roleId, mid);
            }

        }

    }

    /**
     * 查询属于用户的角色和不属于用户的角色
     *
     * @param uuid
     * @return
     */
    @PreAuthorize("hasAuthority('role:queryUnAndNoqueryUn')")
    @PermissionMethod("查询属于用户的角色和不属于用户的角色")
    public UserRoleVo queryUnAndNoqueryUn(String uuid) {
        List<RolesDB> beLogedRoles = rolesDao.findByUserId(uuid);
        List<String> names = beLogedRoles.stream().map(RolesDB::getName).collect(Collectors.toList());
        List<RolesDB> roles = rolesDao.findAll();
        List<RolesTransferVo> beLogedRolesTransferVo = BeanConverterUtil.copyList(beLogedRoles, RolesTransferVo.class);
        List<RolesTransferVo> rolesTransferVos = BeanConverterUtil.copyList(roles, RolesTransferVo.class);
        UserRoleVo userRoleVo = new UserRoleVo()
                .setUserRole(beLogedRolesTransferVo)
                .setRoles(rolesTransferVos);
        return userRoleVo;
    }

    @PreAuthorize("hasAuthority('role:query')")
    @PermissionMethod("角色查询")
    public PagingResult queryRolesPaging(RolesQuery rolesQuery) {
        Specification<RolesDB> specification = new Specification<RolesDB>() {
            @Override
            public Predicate toPredicate(Root<RolesDB> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                if (EmptyUtil.stringE(rolesQuery.getName())) {
                    Path<String> namePath = root.get("name");
                    predicates.add(criteriaBuilder.like(namePath, "%" + rolesQuery.getName() + "%"));
                }
                Path<String> statusPath = root.get("status");
                predicates.add(criteriaBuilder.equal(statusPath, "0"));
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        };
        Pageable pageable = PageRequest.of(rolesQuery.getPage() - 1, rolesQuery.getRows());
        Page<RolesDB> rolesDBS = rolesDao.findAll(specification, pageable);
        PagingResult<RolesVo> pagingResult = new PagingResult<RolesVo>()
                .setTotal(rolesDBS.getTotalElements())
                .setRows(BeanConverterUtil.copyList(rolesDBS.getContent(), RolesVo.class));
        return pagingResult;
    }

    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('role:add')")
    @PermissionMethod("角色新增")
    public void add(String name) {
        RolesDB rolesDB = new RolesDB().setName(name).setStatus(0);
        rolesDao.save(rolesDB);
    }
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('role:delete')")
    @PermissionMethod("角色删除")
    public void delete(String uuid) {
        rolesDao.deleteStatus(uuid);
    }
}
