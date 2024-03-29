package com.ysd.iep.entity.vo;

import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.entity.dto.ModulesDTO;
import lombok.Data;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class PermissionTreeVo {
    private List<PermissionVo> permissions;
    private List<String> pids;
}
