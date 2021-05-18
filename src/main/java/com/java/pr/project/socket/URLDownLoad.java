package com.java.pr.project.socket;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 通过URL下载文件
 */
public class URLDownLoad {
    public static void main(String[] args) throws Exception {
        //1、下载地址
        URL url = new URL("https://uploadfiles.nowcoder.com/images/20180918/4107856_1537253291351_6FABBEF277747726B5C3D65F2D3BA2F9");

        //2、连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("sf.png");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer,0,len);// 写出数据
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect();// 关闭
    }
}
