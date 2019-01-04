package com.ysd.iep.controller;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.util.FileUtil;
import com.ysd.iep.util.GeneralResult;
import com.ysd.iep.util.Tright;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RestController
@ApiIgnore
@Slf4j
@RequestMapping("/generalTright")
public class GeneralTrightController {
    /**
     * 收集所有权限
     * @return
     */
    @GetMapping("/collectPermission")
    public GeneralResult<List<Tright>> collectPermission() {
        Set<Class<?>> clazzs = FileUtil.getClasses("com.ysd.iep.service");
        List<Tright> permissions = new ArrayList<>();
        clazzs.forEach(item -> {
            Method[] methods = item.getDeclaredMethods();
            log.info("检查类{}", item.getName());
            log.info("类里方法的个数为{}", methods.length);
            for (Method method : methods) {
                log.info("检查方法{}", method.getName());
                PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);
                PermissionMethod permissionMethod = method.getAnnotation(PermissionMethod.class);
                if (preAuthorize == null) {
                    log.info("不需要收集权限");
                    continue;
                }
                log.info("找到权限信息");
                String value = preAuthorize.value();
                value = value.split("'")[1];
                //方法名称
                String methodName = permissionMethod.value();
                //类型名称
                String typeName = item.getAnnotation(PermissionType.class).value();
                Tright permission = new Tright()
                        .setPermissionValue(value)
                        .setTypeName(typeName)
                        .setMethodName(methodName);
                permissions.add(permission);
            }
        });
        log.info("收集权限完成,共收集{}条权限信息", permissions.size());
        return new GeneralResult<>(true,permissions);
    }
}
