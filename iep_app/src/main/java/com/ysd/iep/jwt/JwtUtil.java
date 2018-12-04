package com.ysd.iep.jwt;

import com.ysd.iep.properties.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JwtUtil {
    @Autowired
    private static SecurityProperties securityProperties;

    public static Claims tokenConvert(String authorization) throws UnsupportedEncodingException {
        if(securityProperties==null){
            securityProperties=new SecurityProperties();
        }
        String token = StringUtils.substringAfter(authorization, "bearer ");
        String jwtSigningKey = securityProperties.getOauth2().getJwtSigningKey();
        byte[] bytes = jwtSigningKey.getBytes("utf-8");
        Claims claims = Jwts.parser().setSigningKey(bytes).parseClaimsJws(token).getBody();
        return claims;
    }
}