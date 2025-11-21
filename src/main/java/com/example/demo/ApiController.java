package com.example.demo;

import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private ApiClient apiClient;

    public ApiController() {
        this.apiClient = new ApiClient();
    }

    @GetMapping("/getData")
    public String getRequests(@RequestParam int id, @RequestParam String api_key, String userInput3, String userInput4, String userInput5) {
        try {
            return apiClient.getData(id, api_key,  userInput3, userInput4, userInput5);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/postData")
    public String postRequests(@RequestParam int id, @RequestParam String api_key) {
        try {
            return apiClient.postData(id, api_key);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
