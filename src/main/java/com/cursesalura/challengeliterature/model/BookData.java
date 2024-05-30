package com.cursesalura.challengeliterature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        Integer id,
        String title,
        List<AuthorData> authors,
        Integer download_count,
        List<String> languages
) {
}
