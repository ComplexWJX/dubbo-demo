package com.wq.util;

import org.springframework.stereotype.Component;

@Component
public class SetProperties
{
    private String webappPath;

    public String getWebappPath()
    {
        return webappPath;
    }

    public void setWebappPath(String webappPath)
    {
        this.webappPath = webappPath;
    }
    
}
