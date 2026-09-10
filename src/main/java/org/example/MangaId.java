package org.example;

public record MangaId(String value) {
    public MangaId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Идентификатор манги не может быть пустым");
        }
    }
}
