package com.cursesalura.challengeliterature.service;

public interface IConversion {

    <T> T getData(String json, Class<T> classData);
}
