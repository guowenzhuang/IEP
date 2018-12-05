package com.ysd.iep.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.iep.dto.Result;
import com.ysd.iep.dto.UserRegistInfo;
import com.ysd.iep.social.qq.api.QQUserInfo;
import io.micrometer.core.instrument.step.StepRegistryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String execute(Connection<?> connection) {
        ObjectMapper objectMapper = new ObjectMapper();
        QQUserInfo qqUserInfo = null;
        System.out.println(connection.getProfileUrl()+"-----");
        String uuid=UUID.randomUUID().toString();
        try {
            qqUserInfo = objectMapper.readValue(connection.getProfileUrl(), QQUserInfo.class);
            String sql="insert into users(id,LoginName,`Password`,CreateTime) values(?,?,?,?)";
            jdbcTemplate.update(sql, uuid,qqUserInfo.getNickname(),encryptPassword("123456"),new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //根据社交用户信息默认创建用户并返回用户唯一标识
        return uuid;
    }
    private String encryptPassword(String password){
        password = new BCryptPasswordEncoder().encode(password);
        return password;
    }
}
