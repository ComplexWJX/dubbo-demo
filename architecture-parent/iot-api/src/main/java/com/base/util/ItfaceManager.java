package com.base.util;

import java.io.File;
import java.net.URL;

public class ItfaceManager
{

    void init(){
        Class<?> clazz = ItfaceManager.class;
        URL url = clazz.getClassLoader().getResource( "config" );
        File dir = new File(url.getPath());
        File[] files = dir.listFiles();
        System.out.println("<=======================>");
        /*for (File file : files)
        {
            System.out.println(file.getName());
        }*/
    }
}
