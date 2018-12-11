package com.ysd.iep.service;

import com.ysd.iep.dao.DepartmentDao;
import com.ysd.iep.entity.dto.DepartmentDTO;
import com.ysd.iep.entity.po.DepartmentDB;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public  List<DepartmentDTO> department(){
        List<DepartmentDB> departmentDB=departmentDao.findOrderByWeight();
        List<DepartmentDTO> departmentDTOS= BeanConverterUtil.copyList(departmentDB,DepartmentDTO.class);
        return departmentDTOS;
    }
}
