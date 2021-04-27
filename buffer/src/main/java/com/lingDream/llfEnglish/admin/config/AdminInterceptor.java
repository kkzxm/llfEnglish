package com.lingDream.llfEnglish.admin.config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * 这个过滤器是用来过滤未登录状的,
 * 如果session中没有admin,那么就让它返回到登录页面,
 *
 *  除了登录页面之外都需要过滤.
 *  </pre>
 *
 * @Author: LI_Lingfei
 * @CreateTime: 2021-04-01 11:12
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null && modelAndView != null) {
            modelAndView.setViewName("admin/index/login");
        }
    }
}
