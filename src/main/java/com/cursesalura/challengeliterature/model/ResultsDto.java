package com.cursesalura.challengeliterature.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultsDto(
        @JsonAlias("results") List<BookDto> results
) {
}
