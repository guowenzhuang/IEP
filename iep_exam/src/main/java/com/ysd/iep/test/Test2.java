package com.ysd.iep.test;


public class Test2 {

    public static void main(String[] args) {

        Integer second = 4000;
        System.out.println(change(second));

    }

    /**
     * 将秒数转化成时间类型
     */


    /**
     * 将秒数转化成时间类型
     */
    public static String change(int second) {


        int h = 0;
        int d = 0;
        int s = 0;
        int temp = second % 3600;
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





