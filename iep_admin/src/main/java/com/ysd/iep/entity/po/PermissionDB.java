package com.ysd.iep.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "permission", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class PermissionDB {
    @Id
    @Column(name = "permissionId", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String permissionId;
    @Column(name = "permissionValue", nullable = true, length = 50)
    private String permissionValue;
    @Column(name = "permissionModule", nullable = true, length = 50)
    private String permissionModule;
    @Column(name = "permissionName", nullable = true, length = 50)
    private String permissionName;
    @Column(name = "permissionLastUpdateTime", nullable = true,insertable=false)
    private Timestamp permissionLastUpdateTime;

    @ManyToMany(mappedBy = "permissionDBS")
    private List<RolesDB> rolesDBS;


}
