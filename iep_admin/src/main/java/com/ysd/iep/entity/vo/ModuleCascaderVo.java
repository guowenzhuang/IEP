package com.ysd.iep.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class ModuleCascaderVo {
    @JsonProperty("value")
    private Integer id;
    @JsonProperty("label")
    private String name;
    private List<ModuleCascaderVo> children;
}
