package net.wanho.system;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyProcessor implements BeanPostProcessor {


    public MyProcessor()
    {
        super();
        System.out.println("MyProcessor构造方法---------------------------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("MyProcessor.postProcessBeforeInitialization---------------------------");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("MyProcessor.postProcessAfterInitialization---------------------------");
        return o;
    }
}
