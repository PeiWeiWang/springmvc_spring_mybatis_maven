package net.wanho.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBean{
    public void init()
    {
        System.out.println("MyBean.init---------------------------");
    }

    public void destroy()
    {
        System.out.println("MyBean.destory---------------------------");
    }

}
