package com.ysd.iep.properties;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public   class SocialProperties {
    private String filterProcessesUrl="/auth";
    private QQProperties qq=new QQProperties();
    private WeixinProperties weixin = new WeixinProperties();
}
