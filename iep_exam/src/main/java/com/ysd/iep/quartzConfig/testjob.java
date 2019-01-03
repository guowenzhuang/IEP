package com.ysd.iep.quartzConfig;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.entity.Examparper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;

public class testjob implements Job {
    @Autowired
    QuartzManager1 quartzManager1;
    @Autowired
    private ExamparperDao examparperDao;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobSays = dataMap.getString("site");
        System.out.println(jobSays);
        Examparper examparpe=examparperDao.findById(jobSays).orElse(null);
        examparpe.setState("考试中");
        examparperDao.save(examparpe);
      //  System.out.println("正在考试中");
        JobKey jobkey=jobExecutionContext.getJobDetail().getKey();
       // System.out.println("任务 name:"+jobkey.getName()+" and Job group:"+jobkey.getGroup());

        TriggerKey trkey = jobExecutionContext.getTrigger().getKey();
       // System.out.println("触发器 name:"+trkey.getName()+" and Trigger group:"+trkey.getGroup());
        quartzManager1.removeJob(jobkey.getName(),jobkey.getGroup(),trkey.getName(),trkey.getGroup());
      //  System.out.println("考试中任务已经移除");
    }

}
