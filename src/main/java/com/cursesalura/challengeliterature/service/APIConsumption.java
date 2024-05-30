package com.cursesalura.challengeliterature.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConsumption {
    private final HttpClient client;

    public APIConsumption() {
        this.client = HttpClient.newHttpClient();
    }

    public String getData(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            System.err.println("Error during API request: " + e.getMessage());
            return "";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Request was interrupted: " + e.getMessage());
            return "";
        }
    }
}
