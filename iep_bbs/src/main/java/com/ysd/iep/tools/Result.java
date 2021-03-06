package com.ysd.iep.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @author  郭文壮
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Result<T> {
    private Boolean success;
    private T message;
    private String remark;

    public Result(Boolean success) {
        this.success = success;
    }

    public Result(Boolean success, T message) {
        this.success = success;
        this.message = message;
    }
}
