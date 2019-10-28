package com.wq.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/itface")
public class BaseController {

	public HttpServletRequest httpRequest;
	public HttpServletResponse httpResponse;

	public BaseController() {
	}

	@RequestMapping("/request.html")
	public void HandleRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) 
	{
		this.httpRequest = httpRequest;
		this.httpResponse = httpResponse;
		//refactorParams();
	}
	
	private void refactorParams(){
        Enumeration<String> parameterNames = httpRequest.getParameterNames();
        Map<String, String> params = new HashMap<String, String>();
        while (parameterNames.hasMoreElements())
        {
            String paramName = parameterNames.nextElement();
            String paramVal = httpRequest.getParameter(paramName);
            params.put(paramName, paramVal);
        }
        //调用service
            try
            {
                Class<?> clazz = Class.forName(httpRequest.getParameter("itfaceId"));
                Object instance = clazz.newInstance();
                clazz.getDeclaredMethod("", this.getClass());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        
	}
}
