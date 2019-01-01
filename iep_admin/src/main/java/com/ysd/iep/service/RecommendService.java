package com.ysd.iep.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ysd.iep.dao.RecommendDao;
import com.ysd.iep.entity.po.PositionDB;
import com.ysd.iep.entity.po.RecommendDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class RecommendService {
    @Autowired
    private RecommendDao recommendDao;
    public List<RecommendDB> get(PositionDB positionDB){
        return recommendDao.getByPositionId(positionDB);
    }

    @Transactional(rollbackOn = Exception.class)
    public void add(RecommendDB recommendDB)throws Exception {
            recommendDao.save(recommendDB);
    }

    @Transactional(rollbackOn = Exception.class)
    public void del(String coursetId,String positionId){
        recommendDao.del(coursetId, positionId);
    }
    @Transactional(rollbackOn = Exception.class)
    public void delAll(String coursetId,String positionIds){
        String[] ids=positionIds.split(",");
        recommendDao.del(coursetId, ids);
    }

    @Transactional(rollbackOn = Exception.class)
    public void del(String coursetId){
        recommendDao.del(coursetId);
    }


}
