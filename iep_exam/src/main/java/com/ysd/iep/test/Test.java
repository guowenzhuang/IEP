package com.ysd.iep.test;

import com.ysd.iep.entity.Answer;
import com.ysd.iep.util.UUIDUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> idlist = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            idlist.add(UUIDUtils.getUUID());
        }


    }

}
