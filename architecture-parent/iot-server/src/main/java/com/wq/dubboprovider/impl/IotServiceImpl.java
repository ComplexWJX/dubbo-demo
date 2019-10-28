package com.wq.dubboprovider.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.wq.dubboprovider.IotServerService;
@Service("iotServiceImpl")
public class IotServiceImpl implements IotServerService
{

    public Object handle(Map<String, String> param)
    {
        
        return "{'returnCode':'1','resultMsg':'success'}";
    }
}
