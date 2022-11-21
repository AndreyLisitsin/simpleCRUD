package com.lisitsin;

import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;

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

/*
    MainView runner = new MainView();
    runner.start();
*/
/*        URL url = new URL("https://translate.google.com/");
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");

        final Map<String, String> parameters = new HashMap<>();
        parameters.put("sl", "en");
        parameters.put("tl", "ru");
        parameters.put("text", "recipient");
        parameters.put("op","translate");

        connection.setDoOutput(true);
        final DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();



        try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content.toString());
        } catch (final Exception ex) {
            ex.printStackTrace();
        }*/

        final Collection<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("sl", "en"));
        params.add(new BasicNameValuePair("tl", "ru"));
        params.add(new BasicNameValuePair("text", "recipient"));
        params.add(new BasicNameValuePair("op", "translate"));

       try {
           final Content postResultForm = Request.Post("https://translate.google.com/").addHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                   .bodyForm(params, Charset.defaultCharset())
                   .execute().returnContent();
           System.out.println(postResultForm.asString());
       } catch (HttpResponseException e){
           e.printStackTrace();
       }



    }

    public static String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}