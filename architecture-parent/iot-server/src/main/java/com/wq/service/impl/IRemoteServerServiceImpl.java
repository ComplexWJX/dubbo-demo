package com.wq.service.impl;

import com.wq.service.IRemoteServerService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IRemoteServerServiceImpl implements IRemoteServerService {
    @Override
    public Object process() {
        Map result = new HashMap();
        result.put("code",1);
        result.put("msg","success exe at:"+new Date());
        return result;
    }
}
