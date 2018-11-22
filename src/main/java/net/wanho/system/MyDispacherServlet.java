package net.wanho.system;

import org.springframework.web.servlet.DispatcherServlet;

public class MyDispacherServlet extends DispatcherServlet {
    public MyDispacherServlet()
    {
        super();
        System.out.println("MyDispacherServlet构造方法---------------------------");
    }
}
