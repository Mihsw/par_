package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    private ApiClient apiClient;

    public ApiController() {
        this.apiClient = new ApiClient();
    }

    @GetMapping("/getData")
    public String getRequests(@RequestParam int id, @RequestParam String apiKey, String workSpaceSlug, String userInput4, String userInput5) {
        try {
            return apiClient.getData(id, apiKey,  workSpaceSlug, userInput4, userInput5);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @PostMapping("/postData")
    public String postRequests(@RequestParam int id, @RequestParam String apiKey, String workSpaceSlug, String userInput4, String userInput5) {
        try {
            return apiClient.postData(id, apiKey,  workSpaceSlug, userInput4, userInput5);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @PatchMapping("/patchData")
    public String patchRequests(@RequestParam int id, @RequestParam String apiKey, String workSpaceSlug, String userInput4, String userInput5) {
        try {
            return apiClient.patchData(id, apiKey, workSpaceSlug, userInput4, userInput5);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteData")
    public String deleteRequests(@RequestParam int id, @RequestParam String apiKey, String workSpaceSlug, String userInput4, String userInput5) {
        try {
            return apiClient.deleteData(id, apiKey, workSpaceSlug, userInput4, userInput5);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
