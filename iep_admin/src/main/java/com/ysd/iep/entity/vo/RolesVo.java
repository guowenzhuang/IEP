package com.ysd.iep.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class RolesVo {
    private String id;
    private String name;
}
