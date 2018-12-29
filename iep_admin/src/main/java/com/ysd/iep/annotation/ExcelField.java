package com.ysd.iep.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解导出表格时每个字段对应的中文
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
    String value() default "";//对应的中文
    boolean notNull() default false;//是否不能为空
    boolean showDisplay() default false;   //显示是否隐藏
    boolean templaletDisplay() default false;//下载模板是否隐藏
}