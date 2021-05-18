package com.java.pr.project.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */
public class Server {
	public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
		    // 1、我得有一个地址
			// 服务端打开端口8080
			serverSocket = new ServerSocket(8080);
			
			// 在端口8080监听，看看是否有连接请求过来
			System.out.println("监听端口号：8888");

			// 2、等待客户端连接过来
			socket = serverSocket.accept();
			System.out.println("有连接过来:"+socket);

			// 3、读取客户端消息
            is = socket.getInputStream();

            /* 不建议，中文超过1024会乱码
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                String msg = new String(buffer,0,len);
                System.out.println(msg);
            }
            */

            // 管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}finally {

		    // 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
		
		
	}
}
