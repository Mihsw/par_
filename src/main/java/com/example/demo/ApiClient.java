package com.example.demo;

import java.io.IOException;
import java.net.URL;

import okhttp3.*;

public class ApiClient {
    private final String URL_H = "https://api.plane.so/api/v1/workspaces/";
    private OkHttpClient client;

    public ApiClient() {
        this.client = new OkHttpClient();
    }


    public String setBody(int id, String workSpaceSlug, String variable4, String variable5) throws IOException {
        String b;
        switch (id) {
            case 1:
                b = workSpaceSlug + "/projects";
                break;
            case 2:
                b = workSpaceSlug + "/projects/" + variable4 + "/cycles";
                break;

            case 3:
                b = workSpaceSlug + "/projects/" + variable4 + "/issues";
                break;

            case 4:
                b = workSpaceSlug + "/issues/" + variable4;
                break;

            default:
                throw new IllegalArgumentException("Invalid ID: " + id);
        }
        return b;
    }
    public String getData(int id, String apiKey, String workSpaceSlug, String variable4, String variable5) throws IOException {

        String URL_B = setBody(id, workSpaceSlug, variable4, variable5);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B + "/").newBuilder();

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .header("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String postData(int id, String apiKey, String workSpaceSlug, String variable4, String variable5) throws IOException {

        String URL_B = setBody(id, workSpaceSlug, variable4, variable5);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();

        String url = urlBuilder.build().toString();
        RequestBody body = RequestBody.create("", MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String patchData(int id, String apiKey, String workSpaceSlug, String variable4, String variable5) throws IOException {

        String URL_B = setBody(id, workSpaceSlug, variable4, variable5);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();

        String url = urlBuilder.build().toString();
        RequestBody body = RequestBody.create("", MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .patch(body)
                .header("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    public String deleteData(int id, String apiKey, String workSpaceSlug, String variable4, String variable5) throws IOException {

        String URL_B = setBody(id, workSpaceSlug, variable4, variable5);

        HttpUrl.Builder urlBuilder = HttpUrl.parse(URL_H + URL_B).newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .header("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
