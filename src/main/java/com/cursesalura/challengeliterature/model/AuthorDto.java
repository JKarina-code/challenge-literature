package com.cursesalura.challengeliterature.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorDto(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer  deathYear
) {
}
