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
@Table(name = "classes", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class ClassesDB {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    private String code;
    @ManyToOne
    private DepartmentDB departmentDB;
}
