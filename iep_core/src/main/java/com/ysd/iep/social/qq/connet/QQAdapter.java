package com.ysd.iep.social.qq.connet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.iep.social.qq.api.QQ;
import com.ysd.iep.social.qq.api.QQUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * qq适配器 * @author 80795
 * @date 2018/11/12 8:55
 */
@Slf4j
public class QQAdapter implements ApiAdapter<QQ> {

    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ qq, ConnectionValues values) {
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            QQUserInfo userInfo=qq.getUserInfo();
            values.setDisplayName(userInfo.getNickname());
            values.setImageUrl(userInfo.getFigureurl());
            String json=objectMapper.writeValueAsString(userInfo);
            values.setProfileUrl(json);
            log.info("json==>{}",json);
            values.setProviderUserId(userInfo.getOpenId());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {
        //do noting
    }
}
