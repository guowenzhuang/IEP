package com.ysd.iep.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class PermissionVo {
    private String permissionId= UUID.randomUUID().toString();
    @JsonProperty("name")
    private String typeName;
    private List<PermissionChildrenVo> children;

    public PermissionVo() {
    }

    public PermissionVo(String typeName) {
        this.typeName = typeName;
    }
}
