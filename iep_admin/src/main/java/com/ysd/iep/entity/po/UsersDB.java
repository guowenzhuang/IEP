package com.ysd.iep.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "users", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class UsersDB {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    @Column(name = "loginName", nullable = false, length = 50)
    private String loginName;
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @Column(name = "isLockout",insertable=false, nullable = true, length = 2)
    private String isLockout;
    @Column(name = "lastLoginTime", nullable = true)
    private Timestamp lastLoginTime;
    @Column(name = "psdWrongTime",insertable=false ,nullable = true)
    private Integer psdWrongTime;
    @Column(name = "lockTime", nullable = true)
    private Timestamp lockTime;
    @Column(name = "protectEMail", nullable = true, length = 200)
    private String protectEMail;
    @Column(name = "protectMTel", nullable = true, length = 11)
    private String protectMTel;
    @Column(name = "createTime",insertable=false, nullable = true)
    private Timestamp createTime;

    @ManyToMany
    @JoinTable(name = "userroles",joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<RolesDB> rolesDBS;
}
