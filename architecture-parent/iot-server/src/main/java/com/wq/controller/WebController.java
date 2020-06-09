package com.wq.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/itface")
public class WebController
{
    @RequestMapping("request.htm")
    @ResponseBody
    public String index(){
        return "";
    }
}
