package com.ysd.iep.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 院系传输类
 * @author 80795
 * @date 2018/11/12 8:55
 */
@ApiModel("院系传输类")
@Data
@Accessors(chain = true)
public class DepartmentDTO {
    @ApiModelProperty("院系id")
    private String departmentId;
    @ApiModelProperty("院系名称")
    private String name;
    private Integer weight;
}
