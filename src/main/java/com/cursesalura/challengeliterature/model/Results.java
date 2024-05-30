package com.cursesalura.challengeliterature.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Results (
        @JsonAlias("results") List<BookData> books) {
}
