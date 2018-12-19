package com.ysd.iep.service;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.dao.PermissionDao;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.PermissionDB;
import com.ysd.iep.entity.vo.PermissionChildrenVo;
import com.ysd.iep.entity.vo.PermissionTreeVo;
import com.ysd.iep.entity.vo.PermissionVo;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@Slf4j
@PermissionType("权限")
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    /**
     * 获取角色拥有的所有的权限id
     * @param roleId
     * @return
     */
    public List<String> get(String roleId){
        return permissionDao.findByRoleId(roleId);
    }
    /**
     * 获取所有权限
     * @return
     */
    public List<PermissionVo> get(){
        List<PermissionVo> permissionVos=permissionDao.findTypeAll();
        permissionVos.forEach(item -> {
            List<PermissionDB> permissionDBS=permissionDao.getChidlren(item.getTypeName());
            List<PermissionChildrenVo> permissionChildrenVos= BeanConverterUtil.copyList(permissionDBS,PermissionChildrenVo.class);
            item.setChildren(permissionChildrenVos);
        });
        return permissionVos;
    }

    /**
     * 收集所有权限
     * @return
     */

    public Result collectPermission() {
        Set<Class<?>> clazzs = FileUtil.getClasses("com.ysd.iep.service");
        Integer[] rows = new Integer[]{0};
        List<PermissionDB> permissions = new ArrayList<>();
        clazzs.forEach(item -> {
            Method[] methods=item.getDeclaredMethods();
            log.info("检查类{}", item.getName());
            log.info("类里方法的个数为{}", methods.length);
            for (Method method:methods) {
                log.info("检查方法{}", method.getName());
                PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);
                PermissionMethod permissionMethod = method.getAnnotation(PermissionMethod.class);
                if (preAuthorize == null) {
                    log.info("不需要收集权限");
                    return;
                }
                log.info("找到权限信息");
                String value = preAuthorize.value();
                value = value.split("'")[1];
                //方法名称
                String methodName=permissionMethod.value();
                //类型名称
                String typeName=item.getAnnotation(PermissionType.class).value();
                log.info("{} 开始插入数据库", value);
                PermissionDB permission = new PermissionDB()
                        .setPermissionValue(value)
                        .setTypeName(typeName)
                        .setMethodName(methodName);
                        //.setPermissionId(UUID.randomUUID().toString());
                try {
                    Example<PermissionDB> example=Example.of(permission);
                    if(!permissionDao.exists(example)){
                        log.info("检查是否存在:{} 可以插入",false);
                        permissionDao.save(permission);
                        rows[0]++;
                    }else{
                        log.info("检查是否存在:{} 忽略",true);
                    }
                } catch (Exception e) {
                    log.info("此记录已存在");
                }
            }
        });
        log.info("收集权限完成,共收集{}条权限信息", rows[0]);
        return new Result(true, rows[0]);
    }


}
