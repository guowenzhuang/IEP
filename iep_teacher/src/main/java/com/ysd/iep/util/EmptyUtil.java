package com.ysd.iep.util;

import java.util.Date;

/**
 * 空判断工具类
 *
 * @author 郭文壮
 */
public class EmptyUtil {

    /**
     * 字符串空判定
     *
     * @param str 字符串
     * @return 为空返回false 否则返回true
     */
    public static boolean stringE(String str) {
        if (str == null)
            return false;
        if ("".equals(str.trim()))
            return false;
        return true;
    }

    /**
     * int类型null空判定
     *
     * @param i
     * @return
     */
    public static boolean intE(int i) {
        if (i == 0)
            return false;
        return true;
    }

    public static boolean dateE(Date date) {
        if (date == null) {
            return false;
        }
        return true;
    }
}