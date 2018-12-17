package com.ysd.iep.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 对象转换
 * 封装 BeanUtils 的复制对象
 *
 * @author 郭文壮
 */
public class BeanConverterUtil {

    /**
     * 对象转map
     * @param o
     * @return
     */
    public static Map objectToMap(Object o){
        try {
            return org.apache.commons.beanutils.BeanUtils.describe(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return new HashMap();
    }

    /**
     * map转bean
     * @param map
     * @param o
     */
    public static void mapToBean(Map map,Object o){
        try {
            org.apache.commons.beanutils.BeanUtils.populate(o,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * map转bean
     * @param map
     * @param claszz
     */
    public static void mapToBean(Map map,Class claszz){
        try {
            Object o=claszz.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(o,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    /**
     * 复制单个对象
     *
     * @param source 复制的对象
     * @param target 被复制的对象
     */
    public static void copyObject(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 复制单个对象
     *
     * @param source 复制的对象
     * @param clazz 被复制的class
     */
    public static Object copyObject(Object source,Class clazz){
        try {
            Object target=clazz.newInstance();
            copyObject(source, target);
            return target;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 复制单个对象并转成result
     *
     * @param source 复制的对象
     * @param clazz  复制对象的class
     */
    public static Result copyObjectToResult(Object source, Class clazz) {
        Constructor constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor();
            Object o = constructor.newInstance();
            if (source == null) {
                return new Result<>(false, "转换失败 " + source.getClass().getName() + " 为Null");
            }
            BeanUtils.copyProperties(source, o);
            return new Result(true, o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new Result<>(false, "转换失败 " + source.getClass().getName() + " 异常");
    }

    /**
     * 复制集合
     * @param sources 复制的集合
     * @param  tClass 目标集合的class
     * @return tclass对象的集合
     */
    public static List copyList(Collection sources, Class tClass) {
        List classes = new ArrayList<>();
        sources.forEach(item -> {
            try {
                Object target = tClass.newInstance();
                BeanConverterUtil.copyObject(item, target);
                classes.add(target);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
        return classes;
    }

    /**
     * 复制集合
     * @param sources 复制的集合
     * @param  tClass 目标集合的class
     * @param consumer 每次遍历执行的方法
     * @return tclass对象的集合
     */
    public static List copyList(Collection sources, Class tClass, Consumer consumer) {
        List classes = new ArrayList<>();
        sources.forEach(item -> {
            try {
                Object target = tClass.newInstance();
                BeanConverterUtil.copyObject(item, target);
                consumer.accept(target);
                classes.add(target);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
        return classes;
    }

    /**
     * 复制集合并转成Result
     *
     * @param sources 复制的对象
     * @param tClass  被复制的对象
     * @return
     */
    public static Result copyListToResult(Collection sources, Class tClass) {
        List list = BeanConverterUtil.copyList(sources, tClass);
        return new Result(true, list);
    }

    /**
     * 复制集合并转成Result
     *
     * @param sources 复制的对象
     * @param tClass  被复制的对象
     * @param consumer 每次遍历执行的方法
     * @return
     */
    public static Result copyListToResult(Collection sources, Class tClass, Consumer consumer) {
        List list = BeanConverterUtil.copyList(sources, tClass,consumer);
        return new Result(true, list);
    }

    /**
     * 复制集合并转成Result
     *
     * @param sources  复制的对象
     * @param tClass   被复制的对象
     * @param function 复制成list后需要执行的方法
     * @return
     */
    public static Result copyListToResult(Collection sources, Class tClass, Function<List, List> function) {
        List list = BeanConverterUtil.copyList(sources, tClass);
        list = function.apply(list);
        return new Result(true, list);
    }

    /**
     * map转对象
     *
     * @param map
     * @param classzz
     * @param <T>
     * @return
     */
    public static <T> T mapToObj(Map map, Class classzz) {
        //用jackson转换
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(map);
            return (T) mapper.readValue(json, classzz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * list(map) 转 list(对象)
     *
     * @param maps
     * @param classzz
     * @return
     */
    public static List mapsToList(List maps, Class classzz) {
        List list = new ArrayList();
        maps.forEach(item -> {
            try {
                Map map = (Map) item;
                list.add(mapToObj(map, classzz));
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    /**
     * list去重
     * @param list list
     * @return
     */
    public static List removeRepeat(List list){
        Set set=new HashSet(list);
        return  new ArrayList(set);
    }
}
