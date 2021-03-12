package com.first.loan.interceptor;

import com.first.loan.dto.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    private LoginService loginService;
//
//    @Autowired
//    private DashboardConfig dashboardConfig;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String sessionId = SessionHelper.getSessionId(request);
//        LoginUser loginUser = loginService.getLoginUserBySessionId(sessionId);
//        if (sessionId == null || (loginUser == null)) {
//            response.sendRedirect(dashboardConfig.getDashboardCallerLoginPage());
//            return false;
//        }
//        ControllerContext.getContext().setLoginUser(loginUser);
//        return true;
//    }

}
