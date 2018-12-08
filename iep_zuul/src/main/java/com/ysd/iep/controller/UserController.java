package com.ysd.iep.controller;

import com.fasterxml.jackson.annotation.JsonView;

import com.ysd.iep.dto.Result;
import com.ysd.iep.dto.User;
import com.ysd.iep.dto.UserQueryCondition;
import com.ysd.iep.dto.UserRegistInfo;
import com.ysd.iep.jwt.JwtUtil;
import com.ysd.iep.properties.SecurityProperties;
import com.ysd.iep.social.AppSignUpUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RestController
@RequestMapping("/api/oauth")
@Slf4j
public class UserController {
    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    @Autowired
    private AppSignUpUtils appSignUpUtils;
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/userRegist")
    public Result userRegist(UserRegistInfo userRegistInfo){
        String sql="insert into users(id,LoginName,`Password`,ProtectEMail,protectMTel,CreateTime) values(?,?,?,?,?,?)";
        encryptPassword(userRegistInfo);
        jdbcTemplate.update(sql, UUID.randomUUID()+"",userRegistInfo.getName(),userRegistInfo.getPassword(),userRegistInfo.getProtectEMail(),userRegistInfo.getProtectMTel(),new Date());
        return new Result().setSuccess(true);
    }

    private void encryptPassword(UserRegistInfo userInfo){
        String password = userInfo.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userInfo.setPassword(password);
    }


    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request){
        log.info("注册用户{}",user.getUsername());
        //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId=user.getUsername();
        appSignUpUtils.doPostSignUp(userId, new ServletWebRequest(request));
    }
    /**
     * 获取当前登录用户
     * @return
     */
    @GetMapping("/me")
    public Object getCurrentUser(Authentication user,HttpServletRequest request) throws UnsupportedEncodingException {
        String authorization = request.getHeader("Authorization");
        return JwtUtil.tokenConvert(authorization);
    }

    @PostMapping
    @ApiOperation(value = "创建用户")
    public User create(@Valid @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
//		throw new RuntimeException("user not exist");
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
