package com.ysd.iep.social.qq.connet;

import com.ysd.iep.social.qq.api.QQ;
import com.ysd.iep.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * qq服务提供
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {
    private String appId;

    private static final String URL_AUTHORIZE="https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESS_TOKEN="https://graph.qq.com/oauth2.0/token";
    public QQServiceProvider(String appId,String appSecret) {
        super(new QQOAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
        this.appId=appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}
