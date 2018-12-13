package com.ysd.iep.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */


@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("表单登录用户名：" + username);
        String sql = "select * from `users` where loginName=?";
        //映射每行数据
        List<UserInfo> users = jdbcTemplate.query(sql, new Object[]{username}, (RowMapper<UserInfo>) (rs, rowNum) -> {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setId(rs.getString("Id"));
                    userInfo.setName(rs.getString("loginName"));
                    userInfo.setPassword(rs.getString("password"));
                    userInfo.setIsLockout(rs.getString("isLockout"));
                    return userInfo;
                }
        );
        if (users == null || users.size() == 0) {
            throw new BadCredentialsException("用户名找不到");
        }
        UserInfo userInfo = users.get(0);
        return buildUser(userInfo);
    }


    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        System.out.println("社交登录用户id:" + userId);
        //TODO 根据用户名查找用户信息
        //根据查找到的用户是否被冻结
        String sql = "select * from `users` where id=?";
        //映射每行数据
        UserInfo user = jdbcTemplate.query(sql, new Object[]{userId}, (RowMapper<UserInfo>) (rs, rowNum) -> {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setId(rs.getString("Id"));
                    userInfo.setName(rs.getString("loginName"));
                    userInfo.setPassword(rs.getString("password"));
                    userInfo.setIsLockout(rs.getString("isLockout"));
                    return userInfo;
                }
        ).get(0);
        return buildUser(user);

    }

    private SocialUserDetails buildUser(UserInfo userInfo) {

        StringBuffer permissStringBuffer = new StringBuffer();
        String rolesSql = "select id, name from  roles where id in (select RoleId from userroles where userid=?)";
        jdbcTemplate.query(rolesSql, new Object[]{userInfo.getId()}, (RowMapper<String>) (rs, rowNum) -> {
                    permissStringBuffer.append("ROLE_" + rs.getString("name") + ",");
                    String qxSql = "select permissionValue from permission WHERE permissionId in (select permissionId FROM rolepermission where roleId=?)";
                    jdbcTemplate.query(qxSql, new Object[]{rs.getString("id")}, (RowMapper<String>) (qrs, qrowNum) -> {
                        permissStringBuffer.append(qrs.getString("permissionValue") + ",");
                        return "";
                    });
                    return "";
                }
        );
        String permissString = permissStringBuffer.toString();
        if(!permissString.trim().equals("")){
            permissString = permissString.substring(0, permissString.length() - 1);
        }

        if(userInfo.getIsLockout().equals("是")){
            return new SocialUser(userInfo.getName(), userInfo.getPassword(),
                    true, true, true, false,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissString));
        }
        jdbcTemplate.update("update users set lastLoginTime=? WHERE Id=?",new Object[]{new Date(),userInfo.getId()});
        return new SocialUser(userInfo.getName(), userInfo.getPassword(),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(permissString));
    }
}
