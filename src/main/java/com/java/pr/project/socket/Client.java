package com.java.pr.project.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 客户端
 */
public class Client {
public static void main(String[] args) {
	Socket socket = null;
	OutputStream os = null;
	try {
		// 1、要知道服务器的地址、端口
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		int port = 8080;

		// 2、创建一个socket连接
		socket = new Socket(inetAddress,port);

		 // 3、发送消息输出流
		os = socket.getOutputStream();
        os.write("你是猪儿虫吗".getBytes());

	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		// 关闭资源
		if (os != null) {
			try {
				os.close();
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
	}
}
}
