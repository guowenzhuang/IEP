package com.ysd.iep.service;

import com.ysd.iep.dao.ModulesDao;
import com.ysd.iep.entity.dto.ModulesDTO;
import com.ysd.iep.entity.po.ModulesDB;
import com.ysd.iep.util.BeanConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@Slf4j
public class ModulesService {
    @Autowired
    private ModulesDao modulesDao;
    /**
     * 根据角色名获取模块(树级)
     * @param roleName
     * @return
     */
    public List<ModulesDTO>  getByRole(String... roleName){
        log.info("查询模块菜单开始");
        List<ModulesDB> topModules=modulesDao.getByParentIdAndRolesName(0,roleName);
        List<ModulesDTO> modulesDTOS= BeanConverterUtil.copyList(topModules,ModulesDTO.class);
        modulesDTOS.forEach(item -> {
            this.getByParent(item,roleName);
        });
        return modulesDTOS;
    }


    /**
     * 根据父级模块和角色名称查询子级模块
     * @param parentModules 父级模块
     * @param roleName 角色名称
     */
    private void getByParent(ModulesDTO parentModules,String... roleName){
        log.info("查询子级模块 父级模块为:{}",parentModules.getName());
        List<ModulesDB> childrenModules=modulesDao.getByParentIdAndRolesName(parentModules.getId(),roleName);
        List<ModulesDTO> childrenModuleDTOS= BeanConverterUtil.copyList(childrenModules,ModulesDTO.class);
        parentModules.setChildren(childrenModuleDTOS);
        childrenModuleDTOS.forEach(item -> {
            this.getByParent(item,roleName);
        });
    }
}
