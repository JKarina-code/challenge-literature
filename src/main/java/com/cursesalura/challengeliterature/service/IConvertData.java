package com.cursesalura.challengeliterature.service;

public interface IConvertData {
    /**
     * Converts JSON string to an instance of the specified class.
     *
     * @param json      the JSON string to be converted
     * @param classData the class of the type to convert to
     * @param <T>       the type of the result
     * @return an instance of the specified class
     */
    <T> T dataGet(String json, Class<T> classData);
}
