package com.cursesalura.challengeliterature.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConversion {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> classData) {
        try {
            return mapper.readValue(json, classData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}