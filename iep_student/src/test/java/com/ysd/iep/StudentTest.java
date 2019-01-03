package com.ysd.iep;

import com.ysd.iep.entity.StudentRecord;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.repository.StudentRecordDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRecordDao studentRecordDao;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    @Test
    public void insertStudentRecord(){
        StudentRecord studentRecord=new StudentRecord();
        studentRecord.setSid("27a1026f-be4d-4651-9245-578e31d1728a");
        studentRecord.setCid(13);
        studentRecord.setChaid(2);
        studentRecord.setCredits(10);
        studentRecord.setStarttime(new Date());
    }
}
