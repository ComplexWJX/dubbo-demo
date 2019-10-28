package com.wentry.natrual.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server
{
    private ServerSocket server;
    
    Socket client = null;
    
    private Properties config;
    
    {
        InputStream is = Server.class.getClassLoader()
            .getResourceAsStream("config/server.properties");
        config = new Properties();
        try
        {
            config.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void startServer() throws IOException
    {
        startServer(config);
    }
    
    public void startServer(Properties p) throws IOException
    {
        String host = String.valueOf(p.get("host"));
        int port = Integer.valueOf((String)p.get("port"));
        // SocketAddress socketAddress = new InetSocketAddress(host,port);
        server = new ServerSocket(port);
        //设置从Socket读取数据超时
        //server.setSoTimeout(10*1000);
        
        // server.bind(socketAddress , 0);
        System.out.println("系统启动...");
        
        //阻塞
        //client = server.accept();
        System.out.println("accecpted connection from:" + client);
        //readMetrics(client);
        
    }
    
    public void readMetrics(Socket socket) throws IOException
    {
        //获取socket输入
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        
        // server send
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        boolean isAccept = true;
        while (isAccept)
        {
            // 获取client端消息
            String msg = reader.readLine();
            if (msg == null || msg.isEmpty())
            {
                isAccept = false;
                pw.println("server end");
            }
            else
            {
                pw.println("get msg {"+msg+"} from client:" + client);
                
            }
            pw.flush();
        }
        pw.close();
        reader.close();
    }
    
    public void stopServer()
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    if (client != null)
                    {
                        
                        client.close();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) throws IOException
    {
        new Server().startServer();
    }
}
