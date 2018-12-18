package com.ysd.iep.service;

import com.ysd.iep.dao.PositiondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class PositionService {
    @Autowired
    private PositiondDao positiondDao;
    public String get(String code){
        return positiondDao.getByCode(code);
    }
}
