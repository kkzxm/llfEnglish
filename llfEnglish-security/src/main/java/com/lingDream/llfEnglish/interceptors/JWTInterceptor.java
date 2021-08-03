package com.lingDream.llfEnglish.interceptors;

import com.lingDream.llfEnglish.tool.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.lingDream.llfEnglish.tool.utils.SpringBootGetBean.getBean;


/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-06-28 16:07
 */

public class JWTInterceptor implements HandlerInterceptor {
    //预先处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取请求头中的令牌
        final String token = request.getHeader("token");
        final JWTUtils jwtUtils = getBean(JWTUtils.class);
        setResponseHeader(response);
        try {
            jwtUtils.verify(token);
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } catch (Exception e) {
            return false;
        }
    }

    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "content-type, token");
        response.setHeader("Access-Control-Allow-Methods", " GET,POST,OPTIONS,PUT,DELETE");
    }
}
