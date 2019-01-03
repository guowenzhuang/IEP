package com.ysd.iep.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 院系
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Entity
@Table(name = "department", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class DepartmentDB {
    @Id
    @Column(name = "departmentId", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String departmentId;
    private String name;
    private Integer weight;
    @OneToMany(mappedBy = "departmentDB")
    private List<ClassesDB> classesDBS;
}
