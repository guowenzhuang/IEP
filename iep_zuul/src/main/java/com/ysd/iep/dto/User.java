package com.ysd.iep.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class User {
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{}

    private String id;
    private Date birthday;
    @JsonView(UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;

}
