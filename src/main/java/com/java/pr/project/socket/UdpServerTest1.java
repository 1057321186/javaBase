package com.java.pr.project.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

// 服务端
// 还是要等待客户端的链接
public class UdpServerTest1 {
    public static void main(String[] args) throws Exception {
        // 1、开放端口
        DatagramSocket socket = new DatagramSocket(9090);

        // 2、接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);// 阻塞接收

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData()));

        // 关闭连接
        socket.close();
    }
}
