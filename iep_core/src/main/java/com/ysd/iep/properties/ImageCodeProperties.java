package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {
    private int width=67;
    private int height=23;

    public ImageCodeProperties() {
        setLength(4);
    }
}
