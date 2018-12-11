package com.ysd.iep.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @author  郭文壮
 */
@ApiModel("控制层统一返回")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Result<T> {
    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("信息")
    private T message;
    @ApiModelProperty("备注")
    private String remark;

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, T message) {
        this.success = success;
        this.message = message;
    }
}
