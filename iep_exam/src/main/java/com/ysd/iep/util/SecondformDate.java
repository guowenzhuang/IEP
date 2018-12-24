package com.ysd.iep.util;

/**
 * 秒转换成时间类型的工具类
 */
public class SecondformDate {
    /**
     * 秒转换成时间类型
     *
     * @param second
     * @return
     */
    public static String change(long second) {


        long h = 0;
        long d = 0;
        long s = 0;
        long temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        /**
         * String.format("%02d", h)  可以将一位数字转化成两位数字:例1 => 01
         */
        return String.format("%02d", h) + ":" + String.format("%02d", d) + ":" + String.format("%02d", s);
    }
}
