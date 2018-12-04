package com.ysd.iep.social;

import org.springframework.social.security.SocialAuthenticationFilter;

public interface SocialAuthenticationFilterPostProcessor {


    void process(SocialAuthenticationFilter socialAuthenticationFilter);

}