package com.ysd.iep.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "ip-permission")
@Data
@Accessors(chain = true)
public class RolesDB {
    @Id
    @Column(name = "Id", nullable = false, length = 100)
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    private String id;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "Int0", nullable = true)
    private Integer int0;
    @Column(name = "String0", nullable = true, length = 50)
    private String string0;
    @ManyToMany(mappedBy = "rolesDBS",fetch = FetchType.EAGER)
    private List<UsersDB> usersDBS;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "rolemodules",joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "moduleId"))
    private List<ModulesDB> modulesDBS;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "rolepermission",joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private List<PermissionDB> permissionDBS;

    @Override
    public String toString() {
        return "RolesDB{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", int0=" + int0 +
                ", string0='" + string0 + '\'' +
                '}';
    }
}
