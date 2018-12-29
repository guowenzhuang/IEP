package com.ysd.iep.service;

import com.ysd.iep.dao.ClassesDao;
import com.ysd.iep.entity.po.ClassesDB;
import com.ysd.iep.entity.vo.PagingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class ClassesService {
    @Autowired
    private ClassesDao classesDao;
    public PagingResult<ClassesDB> query(){
        return null;
    }
    public void add(ClassesDB classesDB){
        classesDao.save(classesDB);
    }
    public void update(ClassesDB classesDB){
        classesDao.save(classesDB);
    }
    public void delete(String id){
        classesDao.deleteById(id);
    }
}
