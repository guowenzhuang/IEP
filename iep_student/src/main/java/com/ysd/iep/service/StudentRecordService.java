package com.ysd.iep.service;

import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.entity.dto.Chapters;
import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.entity.dto.CourseRecord;
import com.ysd.iep.feign.CourseFeign;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.repository.StudentRecordDao;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.PagingResult;
import com.ysd.iep.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@Slf4j
public class StudentRecordService {
    @Autowired
    private StudentRecordDao studentRecordDao;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    /**
     * 根据学生id分页查询学生的学习记录
     * @param id
     * @param page
     * @param rows
     * @return
     */
    public PagingResult<CourseRecord> query(String id,Integer page, Integer rows) {
        Pageable pageRequest = PageRequest.of(page - 1, rows);
        //查询学生学习记录
        Page<StudentRecord> studentRecordPage = studentRecordDao.findAllMaxCha(id,pageRequest);
        //查询课程
        List<StudentRecord> studentRecords = studentRecordPage.getContent();
        List<Integer> cidList = studentRecords.stream().map(StudentRecord::getCid).collect(Collectors.toList());
        String cids = StringUtils.join(cidList, ",");
        List<Course> courses = teacherFeign.getCoursedetails(cids);

        List courseRecords = BeanConverterUtil.copyList(studentRecords, CourseRecord.class);
        BeanConverterUtil.copyList(courses, courseRecords,item -> {
            CourseRecord courseRecord = (CourseRecord) item;
            Integer cId=courseRecord.getChaid();
            List<Integer> chaIds = courseRecord.getChaIds();
            int i=chaIds.indexOf(cId);
            courseRecord.setChaIndex(i);
        });

        PagingResult pagingResult = new PagingResult();
        pagingResult.setTotal(studentRecordPage.getTotalElements());
        pagingResult.setRows(courseRecords);
        return pagingResult;
    }

    /**
     * 根据学生id和课程id查询所有的章节
     * @param cid 课程id
     * @param id 用户id
     * @return
     */
    public List<Chapters> queryChapter(Integer cid ,String id){
        List<Chapters> list=teacherFeign.queryChapter(cid);
        List<StudentRecord> sr = studentRecordDao.findWatch(id, cid);
        list.forEach(item ->{
            chidrenChapter(item,cid,id,sr);
        });
        return list;
    }

    private void chidrenChapter(Chapters chapter,Integer cid ,String id, List<StudentRecord> sr){
        if(chapter.getChildren()==null || chapter.getChildren().size()==0){
            //最后的子节点
            String watch = "0";
            for (StudentRecord s:sr) {
                if(s.getChaid().equals(chapter.getChaId())){
                    watch=s.getWatchtime();
                }
            }
            String sumTime=chapter.getChaTime();
            String[] split = sumTime.split("-");
            //小时
            Double hour=Double.valueOf(split[0]);
            //分钟
            Double points=Double.valueOf(split[1]);
            //秒
            Double seconds=Double.valueOf(split[2]);
            points+=hour*60;
            //总秒数
            seconds+=points*60;
            //已观看的秒数
            Double w=Double.valueOf(watch);
            chapter.setWatch(w);
            chapter.setProgress(w/seconds*100);
        }else{
            List<Chapters> list=chapter.getChildren();
            list.forEach(item ->{
                chidrenChapter(item,cid,id,sr);
            });
        }
    }

    /**
     * 记录学习时间
     * @param id 用户id
     * @param cid  课程id
     * @param chaId 章节id
     */
    @Transactional(rollbackOn = Exception.class)
    public void recordStuCha(String id,Integer cid,Integer chaId,Double watch){
        StudentRecord record = studentRecordDao.findRecord(id, cid, chaId);
        //第一次学习
        if(record==null){
            record=new StudentRecord();
            record.setStarttime(new Date());
            record.setSid(id);
            record.setWatchtime(watch+"");
            record.setCid(cid);
            record.setChaid(chaId);
        }else{
            Double watch_old=Double.valueOf(record.getWatchtime());
            if(watch>watch_old){
                record.setWatchtime(watch+"");
            }
        }
        studentRecordDao.save(record);
    }
}
