package com.java.pr.project.socket;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


// 不需要连接服务器
public class UdpClientTest1 {
    public static void main(String[] args) throws Exception {
        // 1、建立一个socket
        DatagramSocket socket = new DatagramSocket(8088);

        // 2、建个包
        String msg = "你好啊，服务器!";
        InetAddress localHost= InetAddress.getByName("localhost");
        int port = 9090;

        // 数据，数据的长度起始，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localHost,port);

        // 3、发送包
        socket.send(packet);

        // 4、关闭流
        socket.close();
    }

}
