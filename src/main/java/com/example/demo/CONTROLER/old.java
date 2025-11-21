package com.example.demo.CONTROLER;

import java.io.IOException;
import okhttp3.*;

public class old {
    private final String URL_H = "https://api.plane.so/";
    private OkHttpClient client;

    public old() {
        this.client = new OkHttpClient();
    }

    public String getData(int id, String api_key) throws IOException {
        String URL_B;
        switch (id) {
            case 1:
                URL_B = "endpoint1"; // Specify the endpoint
                break;
            default:
                throw new IllegalArgumentException("Invalid ID: " + id);
        }

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();
        urlBuilder.addQueryParameter("id", String.valueOf(id));

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + api_key) // Include API key if needed
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String postData(int id, String api_key) throws IOException {
        String URL_B = "endpoint2"; // Specify the endpoint

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();
        urlBuilder.addQueryParameter("id", String.valueOf(id));

        String url = urlBuilder.build().toString();
        RequestBody body = RequestBody.create("", MediaType.parse("application/json")); // Customize body

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "Bearer " + api_key) // Include API key if needed
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
