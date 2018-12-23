package com.ysd.iep.entity.properties;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public enum  PermissionEnum {
    /**
     *用户
     */
    USER("user","用户"),
    /**
     *角色
     */
    ROLE("role","角色"),
    /**
     *模块
     */
    MODULE("module","模块"),

    /**
     *课程
     */
    COURCE("cource","课程");
    private final String key;
    private final String value;
    private PermissionEnum(String key,String value){
        this.key = key;
        this.value = value;
    }
    //根据key获取枚举
    public static PermissionEnum getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(PermissionEnum temp:PermissionEnum.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
