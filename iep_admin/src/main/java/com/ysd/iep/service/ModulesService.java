package com.ysd.iep.service;

import com.netflix.discovery.converters.Auto;
import com.ysd.iep.dao.ModulesDao;
import com.ysd.iep.entity.dto.ModulesDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.ModulesDB;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class ModulesService {
    @Autowired
    private ModulesDao modulesDao;
    /**
     * 根据角色名获取模块(树级)
     * @param roleName
     * @return
     */
    public List<ModulesDTO>  getByRole(String roleName){
        List<ModulesDB> topModules=modulesDao.getByParentIdAndRolesName(0,roleName);
        List<ModulesDTO> modulesDTOS= BeanConverterUtil.copyList(topModules,ModulesDTO.class);

        topModules.forEach(item -> {

        });
        return modulesDTOS;
    }
    public void getByParent(ModulesDTO parentModules,String roleName){
        List<ModulesDB> childrenModules=modulesDao.getByParentIdAndRolesName(parentModules.getParentId(),roleName);
        List<ModulesDTO> childrenModuleDtos= BeanConverterUtil.copyList(childrenModules,ModulesDTO.class);
        parentModules.setChildren(childrenModuleDtos);
    }
}
