package br.com.caelum.fj59.carangos.webservice;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import br.com.caelum.fj59.carangos.infra.MyLog;
import br.com.caelum.fj59.carangos.infra.MyServer;


public class WebClient {
    private final String url;

    public WebClient(String relativeUrl) {
        this.url = MyServer.uriFor(relativeUrl);
    }

    public String get() {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);

            MyLog.i("EFETUANDO O GET PARA URL: " + this.url);

            get.setHeader("Accept", "application/json");
            get.setHeader("Content-type", "application/json");

            HttpResponse response = httpClient.execute(get);

            String jsonDeResposta = EntityUtils.toString(response.getEntity());

            MyLog.i("RESPOSTA: " + jsonDeResposta);

            return jsonDeResposta;

        } catch (Exception e) {
            MyLog.e("ZICA: " + e.getMessage());

            throw new RuntimeException(e);
        }
    }

    public String post() {
        return post(null);
    }

    public String post(String json) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);

            if (json != null) {
                post.setEntity(new StringEntity(json));
                post.setHeader("Content-type", "application/json");
            }

            post.setHeader("Accept", "application/json");

            HttpResponse response = httpClient.execute(post);
            String jsonDeResposta = EntityUtils.toString(response.getEntity());

            MyLog.i("JSON DE REPOSTA: " + jsonDeResposta);

            return jsonDeResposta;

        } catch (Exception e) {
            MyLog.i("ZICA NO POST!: " + e.getMessage());

            throw new RuntimeException(e);
        }
    }
}