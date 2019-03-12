package com.bw.bean;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataBean {

    private static String json;

    public static String  getStr(){
          String  path="http://www.xieast.com/api/news/news.php?page=1";
          try {
              URL url=new URL(path);
               HttpURLConnection  conn= (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("GET");
               conn.setReadTimeout(5000);
              int code = conn.getResponseCode();
              if(code==200){
                  InputStream is = conn.getInputStream();
                  ByteArrayOutputStream baos=new ByteArrayOutputStream();
                  int len;
                  byte[] arr=new byte[1024*8];
                  while((len=is.read(arr))!=-1){
                       baos.write(arr,0,len);
                  }
                  String a="";
                  json = baos.toString();
                  json +=a;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return json;
      }
}
