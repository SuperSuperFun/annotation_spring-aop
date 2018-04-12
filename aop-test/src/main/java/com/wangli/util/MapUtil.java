package com.wangli.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MapUtil {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=天安门&destinations=北京大学&ak=0TTIpxL9Vx7IQPYR67j3SpgjIH8Dgb32");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置连接超时时间
            connection.setConnectTimeout(5000);
            //设置读取时间
            connection.setReadTimeout(5000);

            connection.connect();
            //获取响应码
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = -1;
                while ((len=is.read(buf)) != -1) {
                    bos.write(buf,0,len);
                }
                String result = bos.toString();
                System.out.println(result);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
