package com.ysd.iep.quartzConfig;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobTest implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.update(1);
    }
    public  void update(int a){


    }
}
