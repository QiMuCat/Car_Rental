package com.ll.sys.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 10:55
 * Web的工具类
 */

public class WebUtils {
    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 得到当前线程的请求对象
     * */
    public static HttpServletRequest getHttpServletRequest(){
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 得到当前线程的响应对象
     * */
    public static HttpServletResponse getHttpServletResponse(){
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 得到session对象
     * */
    public static HttpSession getHttpSession(){
        return getHttpServletRequest().getSession();
    }

    /**
     * 得到servletContext对象
     * */
    public static String getServletContext(){
        return getHttpServletRequest().getServletPath();
    }
}
