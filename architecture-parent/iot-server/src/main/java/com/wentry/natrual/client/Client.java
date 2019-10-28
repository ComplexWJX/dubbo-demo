package com.wentry.natrual.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;


public class Client
{
    private  Socket socket; 
     private  PrintWriter writer; 
     private  volatile static Client client ; 
     private BufferedReader reader;
    
    public Client(String host, int port)
    {
        try
        {
            this.socket = new Socket();
            //设置连接超时
            SocketAddress socketAddress = new InetSocketAddress(host,port);
            socket.connect(socketAddress, 3000);
            this.writer = new PrintWriter(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 读取服务端返回
     * @throws Exception
     */
     void readMetrics() throws IOException{
      //读取服务端的消息返回
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean isReceive = true;
       // while (isReceive)
        //{
            // receive from server
            String returnMsg = reader.readLine();
            System.out.println(returnMsg);
        //}
       // reader.close();
    }
    
     
     /**
      * send msg to server
      * @param sendMsg
      * @throws IOException
      */
   void write(BufferedReader input) throws IOException{
        // 向服务端发送消息
        boolean isSend = true;
        while (isSend)
        {
            // send to server
            System.out.println("please enter your msg...");
            writer.println(input.readLine());
            //writer.write(input.readLine());
            writer.flush();
            client.readMetrics();
        }
        writer.close();
    }
    
    public static void main(String[] args)
    {
         client = new Client("127.0.0.1", 9999);
            try
            {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                client.write(input);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
}
