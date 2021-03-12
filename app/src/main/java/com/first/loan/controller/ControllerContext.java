package com.first.loan.controller;

import com.first.loan.dto.LoginUser;
import com.google.common.collect.Maps;

import java.util.Map;


public class ControllerContext {

    private static ThreadLocal<ControllerContext> controllerContext = new ThreadLocal<>();

    private Map<Object, Object> context;

    private static final String REAL_IP = "real_ip";

    private static final String REQUEST_ID = "request_id";

    private static final String COOKIES = "cookies";

    private LoginUser loginUser;

    private ControllerContext() {
        context = Maps.newHashMap();
    }

    private static void setContext(ControllerContext context) {
        controllerContext.set(context);
    }

    public static ControllerContext getContext() {
        ControllerContext context = controllerContext.get();
        if (null == context) {
            context = new ControllerContext();
            setContext(context);
        }
        return context;
    }

    public Object get(Object key) {
        return context.get(key);
    }

    public void put(Object key, Object value) {
        context.put(key, value);
    }

    public void setRealIp(String realIp) {
        put(REAL_IP, realIp);
    }

    public String getRealIp() {
        String realIp = (String) get(REAL_IP);
        if (realIp != null) {
            return realIp;
        } else {
            return "0.0.0.0";
        }
    }

    public void setRequestId(String requestId) {
        put(REQUEST_ID, requestId);
    }

    public String getRequestId() {
        return (String) get(REQUEST_ID);
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

}
