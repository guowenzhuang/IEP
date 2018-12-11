package com.ysd.iep.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 模块传输
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class ModulesDTO {
    private Integer id;
    private String name;
    private Integer parentId;
    private String path;
    private Integer weight;
    private String iconClass;
   private List<ModulesDTO> children;
}
