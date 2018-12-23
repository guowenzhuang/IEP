package com.ysd.iep.test;

import com.ysd.iep.entity.Answer;
import com.ysd.iep.util.UUIDUtils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date begin = df.parse("2018-12-23 13:13:20");//考试开始时间
        /**
         *假设考试时长为60分钟
         */
        System.out.println("考试结束时间" + begin.getTime() + 60 * 60);

        /**
         * 使用当前时间与考试结束时间进行比较
         * 如果当前时间大的话,说明考试结束了
         * 如果当前时间和考试结束时间相等,说明考试正好结束
         * 当前时间小,说明还在考试中.
         */

        Date date = df.parse(df.format(new Date()));//当前时间
        long end = begin.getTime() + 60 * 60*1000;
        System.out.println("开考时间" + begin.getTime());
        System.out.println("当前时间" + date.getTime());
        long between = (end - date.getTime());
        System.out.println(between / 1000);


    }

}
