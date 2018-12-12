package com.ysd.iep.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 模块传输类
 * @author 80795
 * @date 2018/11/12 8:55
 */
@ApiModel("模块传输类")
@Data
@Accessors(chain = true)
public class ModulesDTO {
    @ApiModelProperty("模块id")
    private Integer id;
    @ApiModelProperty("模块姓名")
    private String name;
    @ApiModelProperty("模块父级别id")
    private Integer parentId;
    @ApiModelProperty("模块路径")
    private String path;
    @ApiModelProperty("模块权重")
    private Integer weight;
    @ApiModelProperty("模块图标名称")
    private String iconClass;
    @ApiModelProperty("子级模块")
    private List<ModulesDTO> children;
}
