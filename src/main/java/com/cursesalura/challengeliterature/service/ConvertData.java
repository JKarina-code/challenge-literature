package com.cursesalura.challengeliterature.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {
    private final ObjectMapper mapper;
    public ConvertData() {
        this.mapper = new ObjectMapper();
    }
    @Override
    public <T> T dataGet(String json, Class<T> classData) {
        try {
            return mapper.readValue(json, classData);
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON: " + e.getMessage());
            throw new DataConversionException("Failed to convert JSON to " + classData.getSimpleName(), e);
        }
    }
}

class DataConversionException extends RuntimeException {
    public DataConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}