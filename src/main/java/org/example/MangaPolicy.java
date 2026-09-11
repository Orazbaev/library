package org.example;

public class MangaPolicy {
    public MangaStatus move(MangaStatus from, MangaStatus to) {
        if (from == MangaStatus.DRAFT && to == MangaStatus.UNDER_REVIEW) {
            return to;
        }
        if (from == MangaStatus.UNDER_REVIEW && to == MangaStatus.PUBLISHED) {
            return to;
        }

        throw new IllegalStateException("Переход из статуса " + from + " в статус " + to + " запрещен!");
    }
}
