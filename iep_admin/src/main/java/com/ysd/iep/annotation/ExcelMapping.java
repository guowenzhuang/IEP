package com.ysd.iep.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExcelMapping {
    /**
     * 映射对应名称
     * @return
     */
    String value() default "";

    /**
     * 是否支持导出
     * @return
     */
    boolean isExport() default true;

}
