package com.wq.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware
{
    
    private  static ApplicationContext context;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        this.context = applicationContext;
    }
    
    public static <T> T getBean(Class<?> clazz){
        return (T) context.getBean(clazz);
    }
}
