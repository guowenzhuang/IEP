package com.ysd.iep.test;

import java.util.ArrayList;
import java.util.List;


/**
 * 一个for循环打印出九九乘法表
 */
public class Test4 {


    public static void main(String[] args) {

        int i, j;
        for (i = 1, j = 1; j <= 9; ) {
            if (i < j) {
                i++;
                j = 1;
                System.out.println(" ");
            } else {
                System.out.print(j + "*" + i * j + " ");
                if (i * j < 10) {
                    System.out.print(" ");
                }
                j++;
            }


        }
    }
}
