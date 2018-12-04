/**
 * 
 */
package com.ysd.iep.social.weixin.api;

/**
 * 微信API调用接口
 * 
 * @author zhailiang
 *
 */
public interface Weixin {


	WeixinUserInfo getUserInfo(String openId);
	
}
