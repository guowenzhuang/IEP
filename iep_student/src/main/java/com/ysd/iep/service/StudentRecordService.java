package com.ysd.iep.service;

import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.entity.dto.Course;
import com.ysd.iep.entity.dto.CourseRecord;
import com.ysd.iep.feign.CourseFeign;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.repository.StudentRecordDao;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.PagingResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
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
    @Autowired
    private TeacherFeign teacherFeign;

    public PagingResult<CourseRecord> query(String id,Integer page, Integer rows) {
        Pageable pageRequest = PageRequest.of(page - 1, rows);
        //查询学生学习记录
        Page<StudentRecord> studentRecordPage = studentRecordDao.findAllMaxCha(id,pageRequest);
        //查询课程
        List<StudentRecord> studentRecords = studentRecordPage.getContent();
        List<Integer> cidList = studentRecords.stream().map(StudentRecord::getCid).collect(Collectors.toList());
        ;
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
}
