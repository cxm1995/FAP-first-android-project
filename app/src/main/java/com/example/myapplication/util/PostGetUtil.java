package com.example.myapplication.util;

import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * created by cxm1995
 * on 2021/5/10 16:20
 */
public class PostGetUtil {


    /**
     * 使用post方式与服务器通讯
     *
     * @param content
     * @return
     */
    public static String SendPostRequest(String content) {
        HttpURLConnection conn = null;
        try {
            String Strurl = "http://www.baidu.com";
            URL url = new URL(Strurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("ser-Agent", "Fiddler");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(5 * 1000);
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(URLEncoder.encode(content.toString(), "UTF-8").getBytes());
            outputStream.flush();
            outputStream.close();
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                Log.i("PostGetUtil", "post请求成功");
                InputStream in = conn.getInputStream();
                byte[] bytes = new byte[0];
                bytes = new byte[in.available()];
                in.read(bytes);
                String backcontent = new String(bytes);
//                String backcontent = IOUtils.readString(in);
                backcontent = URLDecoder.decode(backcontent, "UTF-8");
                Log.i("PostGetUtil", backcontent);
                in.close();
            } else {
                Log.i("PostGetUtil", "post请求失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }

    /**
     * 使用get方式与服务器通信
     *
     * @param content
     * @return
     */
    public static String SendGetRequest(String content) {

        HttpURLConnection conn = null;
        try {

            String Strurl = "http://www.baidu.com" + content;
            URL url = new URL(Strurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                Log.i("PostGetUtil", "get请求成功");
                InputStream in = conn.getInputStream();
                byte[] bytes = new byte[0];
                bytes = new byte[in.available()];
                in.read(bytes);
                String backcontent = new String(bytes);
//                String backcontent = IOUtils.readString(in);
                backcontent = URLDecoder.decode(backcontent, "UTF-8");
                Log.i("PostGetUtil", backcontent);
                in.close();
            } else {
                Log.i("PostGetUtil", "get请求失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }
}