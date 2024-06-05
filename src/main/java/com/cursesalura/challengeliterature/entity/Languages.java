package com.cursesalura.challengeliterature.entity;

public enum Languages {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    ITALIAN("it"),
    PORTUGUESE("pt");

    private String languagesBooks;

    Languages(String languagesBooks) {
        this.languagesBooks = languagesBooks;
    }

    public static Languages fromString(String text) {
        for (Languages categoria : Languages.values())
            if (categoria.languagesBooks.equalsIgnoreCase(text)) {
                return categoria;
            }
        throw new IllegalArgumentException("Not category found: " + text);
    }

}