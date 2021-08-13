package com.example.market.config;

import kr.sharenshare.keylitadmin.domain.member.AdminDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@AllArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            AdminDto memberSession = (AdminDto) request.getSession().getAttribute("LOGIN_SESSION");
            if (memberSession == null) {
                sendRedirect(request, response);
                return false;
            }
        } catch (Exception e) {
            sendRedirect(request, response);
            return false;
        }

        return true;
    }

    private void sendRedirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + "/login");
        } catch (Exception ignored) {

        }
    }

}
