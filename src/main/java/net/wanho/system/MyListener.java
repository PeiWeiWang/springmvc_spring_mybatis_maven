package net.wanho.system;


import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener extends ContextLoaderListener implements ServletRequestListener {
    public MyListener(){
        super();
        System.out.println("MyListener构造方法---------------------------");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        System.out.println("MyListener.contextInitialized---------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        System.out.println("MyListener.contextDestroyed---------------------------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed---------------------------");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestInitialized---------------------------");
    }
}
