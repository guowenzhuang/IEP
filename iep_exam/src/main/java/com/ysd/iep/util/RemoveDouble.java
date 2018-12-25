package com.ysd.iep.util;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/24
 * 去除集合中重复的元素
 */
public class RemoveDouble {

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


