package com.example.demo;

import java.io.IOException;
import java.net.URL;

import okhttp3.*;

public class ApiClient {
    private final String URL_H = "https://api.plane.so";
    private OkHttpClient client;

    public ApiClient() {
        this.client = new OkHttpClient();
    }

    public String getData(int id, String api_key, String workplace_slug, String variable4, String variable5) throws IOException {
        String URL_B;
        switch (id) {
            case 1:
                URL_B = String.format("/api/v1/workspaces/ %s", workplace_slug + "/projects/");
                break;
            case 2:
                URL_B = String.format("/api/v1/workspaces/ %s", workplace_slug + "/projects/ %s", variable4 + "/cycles/");
                break;

            case 3:
                URL_B = String.format("/api/v1/workspaces/ %s", workplace_slug + "/projects/ %s", variable4 + "/issues/");
                break;

            default:
                throw new IllegalArgumentException("Invalid ID: " + id);
        }

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("x-api-key", api_key)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String postData(int id, String api_key) throws IOException {
        String URL_B = "";

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();

        String url = urlBuilder.build().toString();
        RequestBody body = RequestBody.create("", MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("x-api-key", api_key)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
