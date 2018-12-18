package com.ysd.iep;

import com.ysd.iep.dao.PermissionDao;
import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.entity.po.PermissionDB;
import com.ysd.iep.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolesDao rolesDao;

    /**
     * 更新所有权限
     */
    @Test
    public void contextLoads() {
        System.out.println("执行前");
        permissionService.collectPermission();
        System.out.println("执行结束");
    }

    /**
     * 给管理员增加全部权限
     */
    @Test
    public void initPermission(){
        //管理员id
        String roleId="1b063868-1374-47ad-8460-1441c1e6ec36";
        List<PermissionDB> permissionDBList=permissionDao.findAll();
        permissionDBList.forEach(item ->{
            rolesDao.insertPermission(roleId,item.getPermissionId());
        });
    }
}
