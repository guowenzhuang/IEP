package com.ysd.iep.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@NoArgsConstructor
public class PermissionChildrenVo {
    private String permissionId;
    @JsonProperty("name")
    private String methodName;
    private String typeName;
    private String permissionValue;


}
