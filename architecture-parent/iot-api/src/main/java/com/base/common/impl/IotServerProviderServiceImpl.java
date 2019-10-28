package com.base.common.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.common.IotServerProviderService;

public class IotServerProviderServiceImpl implements IotServerProviderService
{
    private  String classname = "com.wq.dubboprovider.impl.IotServiceImpl";
    
    private static Logger LOG = LoggerFactory.getLogger(IotServerProviderService.class);
    
    @Override
    public Object process(String methodId,Map<String, String> param)
    {
        // TODO 此处实现真正业务
        
        //LOG.info("当前调用接口方法:{}", methodId);
        System.out.println("当前调用接口方法:{}"+ methodId);
        Object result = null;
        try
        {
            Class<?> clazz = Class.forName(classname);
            Method method = clazz.getDeclaredMethod(methodId, Map.class);
            System.out.println("start to call method:"+ method.getName());
            result = method.invoke(clazz.newInstance(), param);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
}
