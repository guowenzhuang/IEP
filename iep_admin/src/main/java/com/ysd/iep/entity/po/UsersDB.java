package com.ysd.iep.entity.po;

import com.ysd.iep.annotation.ExcelField;
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
    @ExcelField(showDisplay=true,templaletDisplay = true)
    private String id;
    @Column(name = "loginName", nullable = false, length = 50)
    @ExcelField(value = "用户名",notNull = true)
    private String loginName;

    @ExcelField(value = "密码",showDisplay = true,templaletDisplay = true)
    @Column(name = "password", nullable = false, length = 50)
    private String password;
    @ExcelField(value = "是否锁定",showDisplay = false,templaletDisplay = true)
    @Column(name = "isLockout",insertable=false, nullable = true, length = 2)
    private String isLockout;
    @ExcelField(value = "最后登录时间",showDisplay = false,templaletDisplay = true)
    @Column(name = "lastLoginTime", nullable = true)
    private Timestamp lastLoginTime;
    @ExcelField(value = "密码错误次数",showDisplay = false,templaletDisplay = true)
    @Column(name = "psdWrongTime",insertable=false ,nullable = true)
    private Integer psdWrongTime;
    @ExcelField(value = "锁定时间",showDisplay = false,templaletDisplay = true)
    @Column(name = "lockTime", nullable = true)
    private Timestamp lockTime;

    @ExcelField(value = "邮箱",showDisplay = false)
    @Column(name = "protectEMail", nullable = true, length = 200)
    private String protectEMail;

    @ExcelField(value = "手机号",showDisplay = false)
    @Column(name = "protectMTel", nullable = true, length = 11)
    private String protectMTel;
    @ExcelField(value = "创建时间",showDisplay = false,templaletDisplay = true)
    @Column(name = "createTime",insertable=false, nullable = true)
    private Timestamp createTime;
    @ExcelField(value = "状态",showDisplay = true,templaletDisplay = true)
    @Column(name = "status",columnDefinition = "int default 0")
    private Integer status;

    @ExcelField(value = "角色",showDisplay = true,templaletDisplay = true)
    @ManyToMany
    @JoinTable(name = "userroles",joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<RolesDB> rolesDBS;
}
