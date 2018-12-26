package com.ysd.iep.service;

import com.ysd.iep.dao.PositiondDao;
import com.ysd.iep.entity.po.PositionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class PositionService {
    @Autowired
    private PositiondDao positiondDao;

    /**
     * 根据code获取位置id
     * @param code
     * @return
     */
    public PositionDB get(String code){
        return positiondDao.getByCode(code);
    }

    public List<PositionDB> get(){
        return positiondDao.findAll();
    }

    public List<Map> get(Integer courId){
        return positiondDao.findNamesByCourId(courId);
    }
}
