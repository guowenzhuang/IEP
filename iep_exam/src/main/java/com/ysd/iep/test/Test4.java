package com.ysd.iep.test;

import java.util.ArrayList;
import java.util.List;

public class Test4 {


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<Integer>();

        list.add(13);
        list.add(5);
        list.add(127);

        Integer min = list.get(0);

        for (Integer item : list) {
            if (item.intValue() > min) {
                min = item;
            }
        }

        System.out.println(min);

    }
}
