package com.ysd.iep.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "modules", schema = "ip-permission", catalog = "")
@Data
@Accessors(chain = true)
public class ModulesDB implements Serializable {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("title")
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "ParentId", nullable = true)
    private Integer parentId;
    @Column(name = "Path", nullable = true, length = 200)
    private String path;
    @Column(name = "Weight", nullable = true)
    private Integer weight;
    @Column(name = "icon_class", nullable = true, length = 20)
    private String iconClass;
    @Column(name = "Ops", nullable = true, length = 100)
    private String ops;
    @Column(name = "Int0", nullable = true)
    private Integer int0;
    @Column(name = "status",columnDefinition = "int default 0")
    private Integer status;

    @JsonIgnore
    @ManyToMany(mappedBy = "modulesDBS")
    private List<RolesDB> rolesDBS;

    /**子组织*/
    @OneToMany(cascade= CascadeType.ALL,mappedBy = "parent",fetch=FetchType.LAZY)
    private List<ModulesDB> children;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ParentId",insertable = false,updatable = false)
    private ModulesDB parent;

}
