package com.ysd.iep.test;

import com.ysd.iep.entity.parameter.ABCD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5 {

    public static void main(String[] args) {

        List<ABCD> abcdList = new ArrayList<>();
        List<ABCD> abcdList2 = new ArrayList<>();

        abcdList.add(new ABCD("A", "aaaaaaaaaaaa"));
        abcdList.add(new ABCD("C", "cccccccccccc"));
        abcdList.add(new ABCD("B", "bbbbbbbbbbbb"));
        abcdList.add(new ABCD("D", "dddddddddddd"));

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < abcdList.size(); i++) {
            stringList.add(abcdList.get(i).getAnswer());
        }

        Collections.sort(stringList);


        for (int k = 0; k < stringList.size(); k++) {
            for (int j = 0; j < abcdList.size(); j++) {
                if (abcdList.get(j).getAnswer().equals(stringList.get(k))) {
                    System.out.println(abcdList.get(j));
                    abcdList2.add(abcdList.get(j));
                }
            }
        }


        System.out.println(stringList);
        System.out.println(abcdList);
        System.out.println(abcdList2);


    }


}
