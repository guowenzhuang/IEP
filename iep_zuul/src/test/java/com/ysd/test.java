package com.ysd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.iep.social.qq.api.QQUserInfo;

import java.io.IOException;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */

public class test {
    public static void main(String[] args) throws IOException {
        String str="{\n" +
                "    \"ret\": 0,\n" +
                "    \"msg\": \"\",\n" +
                "    \"is_lost\":0,\n" +
                "    \"gender\": \"男\",\n" +
                "    \"province\": \"河南\",\n" +
                "    \"city\": \"商丘\",\n" +
                "    \"year\": \"1994\",\n" +
                "    \"constellation\": \"\",\n" +
                "    \"figureurl\": \"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101445963\\/AA0347F6E3BD77713867DDC84D9703A9\\/30\",\n" +
                "    \"figureurl_1\": \"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101445963\\/AA0347F6E3BD77713867DDC84D9703A9\\/50\",\n" +
                "    \"figureurl_2\": \"http:\\/\\/qzapp.qlogo.cn\\/qzapp\\/101445963\\/AA0347F6E3BD77713867DDC84D9703A9\\/100\",\n" +
                "    \"figureurl_qq_1\": \"http:\\/\\/thirdqq.qlogo.cn\\/qqapp\\/101445963\\/AA0347F6E3BD77713867DDC84D9703A9\\/40\",\n" +
                "    \"figureurl_qq_2\": \"http:\\/\\/thirdqq.qlogo.cn\\/qqapp\\/101445963\\/AA0347F6E3BD77713867DDC84D9703A9\\/100\",\n" +
                "    \"is_yellow_vip\": \"0\",\n" +
                "    \"vip\": \"0\",\n" +
                "    \"yellow_vip_level\": \"0\",\n" +
                "    \"level\": \"0\",\n" +
                "    \"is_yellow_year_vip\": \"0\"\n" +
                "}";
        System.out.println(str);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.readValue(str, QQUserInfo.class);

    }
}
