package com.ysd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.iep.service.UserInfo;
import com.ysd.iep.social.qq.api.QQUserInfo;

import java.io.IOException;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */

public class test {
    public static void main(String[] args) throws IOException {
        String str="{\"userInfo\":{\"openId\":\"AA0347F6E3BD77713867DDC84D9703A9\",\"ret\":\"0\",\"msg\":\"\",\"is_lost\":\"0\",\"nickname\":\"test\",\"province\":\"河南\",\"city\":\"商丘\",\"constellation\":\"\",\"year\":\"1994\",\"figureurl\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/30\",\"figureurl_1\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/50\",\"figureurl_2\":\"http://qzapp.qlogo.cn/qzapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/100\",\"figureurl_qq_1\":\"http://thirdqq.qlogo.cn/qqapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/40\",\"figureurl_qq_2\":\"http://thirdqq.qlogo.cn/qqapp/101445963/AA0347F6E3BD77713867DDC84D9703A9/100\",\"gender\":\"男\",\"is_yellow_vip\":\"0\",\"vip\":\"0\",\"yellow_vip_level\":\"0\",\"level\":\"0\",\"is_yellow_year_vip\":\"0\"}}";
        ObjectMapper objectMapper=new ObjectMapper();
        QQUserInfo userInfo=new QQUserInfo();
        userInfo.setNickname("asd");
        String re=objectMapper.writeValueAsString(userInfo);
        System.out.println(re);
        QQUserInfo u=objectMapper.readValue(re, QQUserInfo.class);
        System.out.println(u);

    }
}
