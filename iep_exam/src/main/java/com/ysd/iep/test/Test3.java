package com.ysd.iep.test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cccccccc");
        list.add("cccccccc");
        list.add("zz");
        list.add("zz");
        list.add("zz");
        System.out.println(removeDuplicate(list));


    }

    public static List removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }


}
