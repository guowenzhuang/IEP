package com.ysd.iep.quartzConfig;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.entity.Examparper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class JobTest implements Job {
    @Autowired
    private  QuartzManager1 quartzManager1;
    @Autowired
    private ExamparperDao examparperDao;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("考试已结束");
        String jobSays = dataMap.getString("site");
        System.out.println(jobSays);
        Examparper examparpe=examparperDao.findById(jobSays).orElse(null);
        examparpe.setState("考试结束");
        examparperDao.save(examparpe);
        System.out.println("考试已结束");
        JobKey jobkey=jobExecutionContext.getJobDetail().getKey();
     //   System.out.println("任务 name:"+jobkey.getName()+" and Job group:"+jobkey.getGroup());

        TriggerKey trkey = jobExecutionContext.getTrigger().getKey();
      //  System.out.println("触发器 name:"+trkey.getName()+" and Trigger group:"+trkey.getGroup());
        quartzManager1.removeJob(jobkey.getName(),jobkey.getGroup(),trkey.getName(),trkey.getGroup());
       // System.out.println("考试结束任务已经移除");


    }
    public void update (String jobSays){

    }
}
