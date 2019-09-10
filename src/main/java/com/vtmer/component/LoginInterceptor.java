package com.vtmer.component;

import com.vtmer.domain.Admin;
import com.vtmer.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        System.out.println(111);
        if (cookies == null) {
            System.out.println(222);
            for (Cookie cookie :
                    cookies) {
                System.out.println(333);
                if (cookie.getName().equals("sessionId")){
                    System.out.println(444);
                    return true;
                }
            }
            return true;
        }
        response.sendRedirect("/admin/login");
        return false;
    }*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("adminInfo");
        if (admin == null) {
            System.out.println("登陆验证失败");
            response.sendRedirect("/admin/login");
            return false;
        } else {
            System.out.println("登陆验证成功");
            return true;
        }
    }


}
