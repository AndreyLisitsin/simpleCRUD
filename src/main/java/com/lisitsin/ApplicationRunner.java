package com.lisitsin;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ApplicationRunner {
    public static void main(String[] args) throws Exception{


    MainView runner = new MainView();
    runner.start();

/*        final CloseableHttpClient httpclient = HttpClients.createDefault();

        final HttpUriRequest httpGet = new HttpGet("https://www.dns-shop.ru/product/8a4dfe1ce0512ff2/videokarta-gigabyte-geforce-rtx-3080-turbo-lhr-gv-n3080turbo-10gd-rev20/");
        try (
                CloseableHttpResponse response1 = httpclient.execute(httpGet)
        ){
            final HttpEntity entity1 = response1.getEntity();
            System.out.println(EntityUtils.toString(entity1));
        }*/

    }
}