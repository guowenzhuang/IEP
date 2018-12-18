package com.ysd.iep.service;

import com.ysd.iep.dao.RecommendDao;
import com.ysd.iep.entity.po.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class RecommendService {
    @Autowired
    private RecommendDao recommendDao;
    public List<Recommend> get(String positionId){
        return recommendDao.getByPositionId(positionId);
    }
}
