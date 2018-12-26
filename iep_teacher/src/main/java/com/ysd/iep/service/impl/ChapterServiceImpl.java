package com.ysd.iep.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.util.EmptyUtil;
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
        if(EmptyUtil.stringE(chapters.getChaName()))
            c.setChaName(chapters.getChaName());

        if(EmptyUtil.stringE(chapters.getChaViurl()))
            c.setChaViurl(chapters.getChaViurl());

        if(EmptyUtil.intE(chapters.getChaCourid()))
            c.setChaCourid(chapters.getChaCourid());

        if(EmptyUtil.stringE(chapters.getChaSize()))
            c.setChaSize(chapters.getChaSize());

        if(EmptyUtil.stringE(chapters.getChaTime()))
            c.setChaTime(chapters.getChaTime());

        if(EmptyUtil.stringE(chapters.getChalastModified()))
            c.setChalastModified(chapters.getChalastModified());

        if(EmptyUtil.stringE(chapters.getChaType()))
            c.setChaType(chapters.getChaType());

        if(EmptyUtil.stringE(chapters.getChaPpturl()))
            c.setChaPpturl(chapters.getChaPpturl());

        if(EmptyUtil.stringE(chapters.getChaDocurl()))
            c.setChaDocurl(chapters.getChaDocurl());
        chaperRepo.save(c);
        return new Result(true);
    }

    @Override
    public Result queryCountById(Integer chaCourid) {
         chaperRepo.queryCountById(chaCourid);
        return new Result(true);
    }


}