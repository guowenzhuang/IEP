package com.ysd.iep.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.ysd.iep.entity.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.ChapterRepository;
import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.Course;
import com.ysd.iep.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chaperRepo;

    /**
     * 查询章节
     *
     * @return
     */
    @Override
    public List<Chapters> querychapterTree(Integer courid) {
        List<Chapters> rootList = chaperRepo.queryTreeChildrenById(0, courid);
        System.out.println("查询出所有根菜单rootList==>" + rootList);
        this.setTreeChildrens(rootList, courid);
        return rootList;
    }

    /**
     * 给菜单模块 设置孩子
     *
     * @param parentList
     */
    private void setTreeChildrens(List<Chapters> parentList, Integer courId) {
        for (Chapters c : parentList) {
            //查出子菜单
            List<Chapters> childrenList = chaperRepo.queryTreeChildrenById(c.getChaId(), courId);
            // 如果没有子菜单则递归结束
            if (childrenList == null || childrenList.isEmpty()) {// 有子菜单
            } else {
                // 设置子菜单
                System.out.println("设置的子菜单是=>" + childrenList);
                c.setChildren(childrenList);
                // 如果有子菜单则继续递归设置子菜单
                this.setTreeChildrens(childrenList, courId);
            }
        }

    }

    @Override
    public Result insertChapters(Chapters chapters) {
        chaperRepo.save(chapters);
        return new Result(true);
    }

    @Override
    public Result deleteChapters(Integer chaId) {
        List<Chapters> modulesDBS = chaperRepo.queryChildren(chaId);
        if (modulesDBS.size() > 0) {
            return new Result(false);
        }
        chaperRepo.deleteById(chaId);
        return new Result(true);
    }

    /**
     * 根据章节id修改视频的路径和视频的时长
     */
    @Override
    public Result updateCourse(Chapters chapters) {
        Chapters c = chaperRepo.getOne(chapters.getChaId());
        c.setChaName(chapters.getChaName());
        c.setChaViurl(chapters.getChaViurl());
        c.setChaCourid(chapters.getChaCourid());
        c.setChaSize(chapters.getChaSize());
        c.setChaTime(chapters.getChaTime());
        c.setChalastModified(chapters.getChalastModified());
        c.setChaType(chapters.getChaType());
        chaperRepo.save(c);
        return new Result(true);
    }


}