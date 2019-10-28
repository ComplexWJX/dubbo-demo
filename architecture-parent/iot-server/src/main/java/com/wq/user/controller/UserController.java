package com.wq.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.wq.controller.BaseController;
import com.wq.user.dao.WqUserDao;
import com.wq.util.SetProperties;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
    @Autowired
    private WqUserDao wqUserDao;
    
    @Autowired
    SetProperties setProperties;
    
    private String ALBUMPATH = "album/";
    
    @RequestMapping("/hello")
    public String showLogin()
    {
        return "hello";
    }
    
    @ResponseBody
    @RequestMapping("/login")
    public String login()
    {
        Map<String, Object> param = new HashMap<String, Object>();
        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");
        param.put("username", username);
        param.put("password", password);
        List<Map<String, Object>> result = (List<Map<String, Object>>)wqUserDao.queryOne(param);
        
        return JSONUtils.toJSONString(result);
    }
    
    @ResponseBody
    @RequestMapping("/regist")
    public String regist(@RequestParam("icon") MultipartFile file,
        HttpServletRequest httpRequest)
    {
        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        param.put("password", password);
        saveIcon(file);
        return "";
    }
    
    private void saveIcon(MultipartFile... file)
    {
        String webappPath = setProperties.getWebappPath();
        String path = webappPath + ALBUMPATH;
        File dir = new File(path);
        if (!dir.exists())
        {
            dir.mkdirs();
        }
        for (MultipartFile f : file)
        {
            String filename = f.getOriginalFilename();
            try
            {
                f.transferTo(new File(path + filename));
            }
            catch (IllegalStateException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }
    
    @ResponseBody
    @RequestMapping(value = "/userList")
    public String userList()
    {
        
        Map<String, Object> param = new HashMap<String, Object>();
        List<Map<String, Object>> userList = wqUserDao.getUserList(param);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("total", userList.size());
        resultMap.put("rows", userList);
        return JSONUtils.toJSONString(resultMap);
    }
    
}
