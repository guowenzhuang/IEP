package com.ysd.iep.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class UserRoleVo {
    /**
     * 属于用户的角色
     */
    private List<RolesVo> userRole;
    /**
     * 不属于用户的角色
     */
    private List<RolesVo> userNoRole;
}
