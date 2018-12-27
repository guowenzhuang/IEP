package com.ysd.iep.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * long 转换成Date
 */
public class Longtodate {


    public static String longToDate(long lo) {

        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);

    }

}