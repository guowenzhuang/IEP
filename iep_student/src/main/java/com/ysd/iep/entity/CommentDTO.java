package com.ysd.iep.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class CommentDTO {
    private Integer cid;
    private Long sum;

    public CommentDTO(Integer cid, Long sum) {
        this.cid = cid;
        this.sum = sum;
    }
}
