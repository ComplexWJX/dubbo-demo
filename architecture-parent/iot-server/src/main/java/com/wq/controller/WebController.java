package com.wq.controller;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wq.user.model.WqUser;

@Controller
@RequestMapping("/itface")
public class WebController
{
    @RequestMapping("request.htm")
    @ResponseBody
    public String index(){
        WqUser wqUser = new WqUser();
        wqUser.setName("tom");
        wqUser.setPassword("abc");
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("exe at:" + new Date());
                
            }
        }, 3*1000);
        return wqUser.toString();
    }
}
