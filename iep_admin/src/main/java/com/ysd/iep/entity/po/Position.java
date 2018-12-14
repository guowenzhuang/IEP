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
@Table(name = "position", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class Position {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    /**
     * 位置名称
     */
    private String name;
    /**
     * 位置编号
     */
    private String code;
}
