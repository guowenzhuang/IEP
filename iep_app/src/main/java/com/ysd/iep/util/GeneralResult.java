package com.ysd.iep.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class GeneralResult<T> {
    private Boolean success;
    private T message;
    private String remark;

    public GeneralResult(Boolean success) {
        this.success = success;
    }

    public GeneralResult(Boolean success, T message) {
        this.success = success;
        this.message = message;
    }

}
