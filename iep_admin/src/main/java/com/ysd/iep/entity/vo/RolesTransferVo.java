package com.ysd.iep.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class RolesTransferVo {
    @JsonProperty("key")
    private String id;
    @JsonProperty("label")
    private String name;
}
