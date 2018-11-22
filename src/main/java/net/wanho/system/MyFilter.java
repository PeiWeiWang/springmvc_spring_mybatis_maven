package net.wanho.system;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public MyFilter()
    {
        System.out.println("MYfilter 构造方法---------------------------");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFiltr.init---------------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFiltr.destroy---------------------------");
    }
}
