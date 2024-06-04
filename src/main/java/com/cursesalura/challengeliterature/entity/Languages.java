package com.cursesalura.challengeliterature.entity;

public enum Languages {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    ITALIAN("it"),
    PORTUGUESE("pt");

    private String languagesAlura;

    Languages(String languagesAlura) {
        this.languagesAlura = languagesAlura;
    }

    public static Languages fromString(String text) {
        for (Languages categoria : Languages.values())
            if (categoria.languagesAlura.equalsIgnoreCase(text)) {
                return categoria;
            }
        throw new IllegalArgumentException("Not category found: " + text);
    }

}