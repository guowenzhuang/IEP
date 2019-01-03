package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Examrubric;
import lombok.Data;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/23
 * 点击考试返回前端的数据实体类
 */
@Data
public class BeginexamFan {
    private Boolean success;
    private List<Examrubric> examrubricslist;
    private Object remark;
}
