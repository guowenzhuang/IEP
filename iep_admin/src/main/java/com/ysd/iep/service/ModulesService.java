package com.ysd.iep.service;

import com.ysd.iep.dao.ModulesDao;
import com.ysd.iep.entity.dto.ModulesDTO;
import com.ysd.iep.entity.po.ModulesDB;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.vo.ModuleTreeVo;
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
     * 获取所有模块并选中角色拥有的模块
     * @param roleid  角色id
     * @return
     */
    public ModuleTreeVo getAllCheckRole(String roleid){
        //最高级模块
        List<ModulesDB> modulesDBS=modulesDao.findByParentId(0);
        //转换类型
        List<ModulesDTO> modulesDTOS=BeanConverterUtil.copyList(modulesDBS,ModulesDTO.class);
        //获取角色id拥有的模块id集合
        List<Integer> mIds=modulesDao.findModuleIds(roleid);
        for (ModulesDTO modulesDTO:modulesDTOS) {
            getChidren(modulesDTO);
        }
        ModuleTreeVo moduleTreeVo=new ModuleTreeVo();
        moduleTreeVo.setMids(mIds);
        moduleTreeVo.setModules(modulesDTOS);
        return moduleTreeVo;
    }
    private void getChidren(ModulesDTO parentModule){
        //获取子级模块
        List<ModulesDB> modulesDBS=modulesDao.findByParentId(parentModule.getId());
        //转换类型
        List<ModulesDTO> modulesDTOS=BeanConverterUtil.copyList(modulesDBS,ModulesDTO.class);
        parentModule.setChildren(modulesDTOS);
        for (ModulesDTO modulesDTO:modulesDTOS) {
            getChidren(modulesDTO);
        }
    }
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
