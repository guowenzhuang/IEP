package com.ysd.iep.test;

import com.ysd.iep.entity.Answer;
import com.ysd.iep.util.UUIDUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {





        /*List<String> idlist = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            idlist.add(UUIDUtils.getUUID());
        }*/
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        Map<String, String> map = new HashMap<>();
        map.put("qq", "不好");
        map.put("gg", "hahha");
        map.put("cc", "不好");
        map.put("zz", "hahha");


        map.forEach((key, value) -> {
            System.out.println(key + "=>" + value);
        });

        /*list.forEach(val)->{

        }*/



        /*String c = "CCCCCCCCCCCCC";
        System.out.println(c.join("").split(","));*/

       /* for (int i = 0; i < c.length(); i++) {
            c.charAt(i) += ",";
        }
*/
    }

}
