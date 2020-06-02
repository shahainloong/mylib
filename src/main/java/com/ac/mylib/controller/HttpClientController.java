package com.ac.mylib.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 这个类是我用来学习httpclient的，以手动刷新public open API为例
 *
 * @author Echo
 */
@RestController
@RequestMapping(path = "/httpclient")
public class HttpClientController {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientController.class);

    @RequestMapping(path = "/get")
    public String get() {
        String result = "";
        HttpClient client = getRestClient();
        try {
//            HttpResponse response = client.execute(buildRequestHeaders(new HttpGet("http://localhost:8080/client/read?id=1")));
            HttpResponse response = client.execute(new HttpGet("https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE"));
            result = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            logger.info("Error is here: {}" + e.getMessage());
        }
        return result;
    }

    public HttpClient getRestClient() {
        HttpClientBuilder requestBuilder = HttpClientBuilder.create();
        HttpClient client = requestBuilder.build();
        return client;
    }

    private HttpUriRequest buildRequestHeaders(HttpUriRequest request) {
        request.addHeader("Accept-Language", "en-US,en;q=0.8");
        request.addHeader("Accept", "application/json");
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Authorization", "Basic QzUyOTQ4MDM6RWNob0BlYXA1");
        return request;
    }

    public static void main(String[] args) {
        String result = "";
//        1、创建一个httpclient对象
        HttpClient client = HttpClientBuilder.create().build();
        try {
//            HttpResponse response = client.execute(buildRequestHeaders(new HttpGet("http://localhost:8080/client/read?id=1")));
//            2、创建一个request对象
            HttpGet httpGet = new HttpGet("https://rapid.sap.com/authoring/api/v1/buildSi2sc/read/005056821C321ED89EDC1DCFDF8660FE");
//            3、使用HTTP client来执行request对象
            HttpResponse response = client.execute(httpGet);
//            4、处理对应的response
            result = EntityUtils.toString(response.getEntity());

            System.out.println(result);
        } catch (IOException e) {
            logger.info("Error is here: {}" + e.getMessage());
        }
    }

}
