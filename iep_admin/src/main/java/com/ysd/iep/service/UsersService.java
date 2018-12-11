package com.ysd.iep.service;

import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;
    /**
     * 根据哟用户名查找用户
     * @param name
     * @return
     */
    public UsersDTO userByName(String name){
        UsersDB usersDB= usersDao.findTopByLoginName(name);
        UsersDTO usersDTO= (UsersDTO) BeanConverterUtil.copyObject(usersDB,UsersDTO.class);
        return usersDTO;
    }
}
