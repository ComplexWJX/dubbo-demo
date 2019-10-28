package com.wq.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swetake.util.Qrcode;

@Controller
@RequestMapping("/Qrcode")
public class QrcodeUtil
{
    /**
     * 生成二维码
     * @param request
     * @param response
     */
    @RequestMapping("getQrcode")
    public void generateQrcode(HttpServletRequest request,HttpServletResponse response){
        Qrcode x=new Qrcode();
        x.setQrcodeErrorCorrect('M');//纠错等级
        x.setQrcodeEncodeMode('B');//其他字符
        x.setQrcodeVersion(7);//版本号
        String qrData="http://nba01.com";//放你自己的连接
        int width=67+12*(7-1);
        int height=67+12*(7-1);//7为版本号
        BufferedImage  bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D gs=bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);
        int pixoff=2;//偏移量
        byte[] d = null;
        try
        {
            d = qrData.getBytes("gb2312");
        }
        catch (UnsupportedEncodingException e1)
        {
            e1.printStackTrace();
        }
        if (d.length>0 && d.length <120){
            boolean[][] s = x.calQrcode(d);
            for (int c=0;c<s.length;c++){
              for (int j=0;j<s.length;j++){
                if (s[j][c]) {
                   gs.fillRect(j*3+pixoff,c*3+pixoff,3,3);
                }
              }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        try
        {
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
