package com.wq.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import com.wq.service.IRemoteServerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.base.common.IotServerProviderService;
import com.wq.task.TimerJob;

@Controller
@RequestMapping("/itface")
public class WebController
{
    @Autowired
    private IotServerProviderService iotServerProviderService;

    @Autowired
    private IRemoteServerService remoteServerService;

    private static Logger LOG = Logger.getLogger(WebController.class);

    @RequestMapping("request.htm")
    @ResponseBody
    public String index()
    {
        Map<String, String> param = new HashMap<>();
        param.put("", "");
        Object result = iotServerProviderService.process("handle",param);
        //new Timer().schedule(new TimerJob(), 1000);
        new TimerJob().run();
        return JSONUtils.toJSONString(result);
    }

    @RequestMapping("getMsg")
    @ResponseBody
    public String getMsg()
    {
        Object result = remoteServerService.process();
        return JSONUtils.toJSONString(result);
    }

    public static void main(String[] args)
    {
        LOG.info("hello");
    }
}
