package com.example.auth.config;

import com.example.auth.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义身份证认证失败返回数据格式
 * Created by WenChen on 2019/6/27.
 */
@Component(value = "customAuthentication")
public class CustomAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint{

    private Logger log = LoggerFactory.getLogger(CustomAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.info(" ====================================================== ");
        log.info("请求url：" +httpServletRequest.getRequestURI());
        log.info("  ============ 身份认证失败..................... ");
        log.info(e.getMessage());
        log.info(e.getLocalizedMessage());
        e.printStackTrace();
        Map<String,String> map =  new HashMap<>();
        map.put("status","401");
        map.put("message",e.getMessage());
        map.put("path", httpServletRequest.getServletPath());
        map.put("timestamp", String.valueOf(LocalDateTime.now()));
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ResultUtil.writeJavaScript(httpServletResponse,map);
    }
}
