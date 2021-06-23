package com.ll.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: 柒木Cat
 * @date: 2021/6/20 9:25
 */

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //取到ServletContext
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("ll",context.getContextPath());
        System.out.println("--------Servlet容器创建成功 alfred被放到ServletContext作用域--------");
    }
}
