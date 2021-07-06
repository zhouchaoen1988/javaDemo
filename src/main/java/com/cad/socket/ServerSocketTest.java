package com.cad.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

    public static void main(String[] args)   {
        // 初始化服务端socket并且绑定9999端口
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9999);
            //等待客户端的连接
            Socket socket = serverSocket.accept();
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            //获取输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输出流，并构造PrintWriter对象
            //读取一行数据
            String readLine = bufferedReader.readLine();
            // 输出打印
            System.out.println(readLine);
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
