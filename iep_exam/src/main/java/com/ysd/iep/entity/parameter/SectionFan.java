package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Sectionexamrubric;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/29
 * 章节测试返回实体类
 */
@Data
@AllArgsConstructor
public class SectionFan {
    private List<Sectionexamrubric> sectionexamrubricList;
    private Integer total;
}
