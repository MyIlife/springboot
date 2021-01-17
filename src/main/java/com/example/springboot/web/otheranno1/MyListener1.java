package com.example.springboot.web.otheranno1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener1 implements ServletContextListener {
    /**
     * 项目初始化完成
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("项目启动，初始化完成");
    }

    /**
     * 项目销毁
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("项目销毁");
    }
}
