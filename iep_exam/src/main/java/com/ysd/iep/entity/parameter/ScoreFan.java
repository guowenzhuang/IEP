package com.ysd.iep.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gaozhongye
 * @date 2019/1/4
 *
 * 分数以及合格与否实体类
 */
@Data
@AllArgsConstructor
public class ScoreFan {

    private Integer total;//总分
    private String isqualified;//是否合格
}
