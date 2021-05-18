package com.java.pr.project.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试IP
 */
public class Test1 {
    public static void main(String[] args) {

        try {
            // 查询本机地址
            InetAddress byName1 = InetAddress.getByName("127.0.0.1");
            System.out.println(byName1);

            InetAddress byName2 = InetAddress.getByName("localhost");
            System.out.println(byName2);

            InetAddress byName3 = InetAddress.getLocalHost();
            System.out.println(byName3);

            // 查询网站ip地址
            InetAddress byName4 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName4);

            // 常用方法
            System.out.println(byName4.getHostAddress());
            System.out.println(byName4.getCanonicalHostName());// 规范的名字
            System.out.println(byName4.getHostAddress());// IP
            System.out.println(byName4.getHostName());// 域名


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
