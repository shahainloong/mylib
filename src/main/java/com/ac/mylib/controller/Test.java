package com.ac.mylib.controller;

import org.apache.poi.util.StringUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

public class Test implements SwingConstants {

  /**
   * 请求的url链接  返回的是json字符串
   * @param urlStr
   * @return
   */
  public static String getURLContent(String urlStr) throws Exception {
    String ticket = "";//登录凭证
    String url_str = "https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE";//获取用户认证的帐号URL
    String ticket_url = url_str + ticket;
    URL url = new URL(ticket_url);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.connect();

    int code = connection.getResponseCode();
    if (code == 404) {
      throw new Exception("认证无效，找不到此次认证的会话信息！");
    }
    if (code == 500) {
      throw new Exception("认证服务器发生内部错误！");
    }
    if (code != 200) {
      throw new Exception("发生其它错误，认证服务器返回 " + code);
    }
    InputStream is = connection.getInputStream();
    byte[] response = new byte[is.available()];
    is.read(response);
    is.close();
    if (response == null || response.length == 0) {
      throw new Exception("认证无效，找不到此次认证的会话信息！");
    }
    String userId = new String(response, "UTF-8");
    return userId;

  }

  public static void main(String[] args) throws Exception {

    String url = "https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE";
    String updateUrl = "https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE";
    System.out.println(url);
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.set("Accept", "text/html;charset=utf-8");

    HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);

    RestTemplate template = new RestTemplate();
    ResponseEntity<String> response = template.exchange(
            url, HttpMethod.GET, requestEntity,
            String.class);
    System.out.println(response);
    System.out.println("---------------------------");

    String resp = restTemplate.getForObject(updateUrl, String.class);
    System.out.println(resp);
    System.out.println(response.getStatusCode());
    System.out.println(response.getHeaders());
  }
}
