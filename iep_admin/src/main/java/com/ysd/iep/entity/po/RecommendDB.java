package com.ysd.iep.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Entity
@Table(name = "recommend", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class RecommendDB {
    /**
     * id
     */
    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    /**
     * 推荐课程id
     */
    private Integer coursetId;
    /**
     * 推荐位置id
     */
    private String positionId;
    /**
     * 权重
     */
    private Integer weight;

}
