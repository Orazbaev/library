package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class MangaPolicyTest {
    private final MangaPolicy policy = new MangaPolicy();

    @ParameterizedTest
    @CsvSource({
            "DRAFT, UNDER_REVIEW, false",
            "UNDER_REVIEW, PUBLISHED, false",
            "DRAFT, PUBLISHED, true",
            "PUBLISHED, UNDER_REVIEW, true"
    })
    public void testTransitions(String fromStr, String toStr, boolean shouldFail) {
        MangaStatus from = MangaStatus.valueOf(fromStr);
        MangaStatus to = MangaStatus.valueOf(toStr);

        if (shouldFail) {
            assertThrows(IllegalStateException.class, () -> policy.move(from, to));
        } else {
            assertEquals(to, policy.move(from, to));
        }
    }

    @Test
    public void testNullOrEmptyIdentifier() {
        assertThrows(IllegalArgumentException.class, () -> new MangaId(null));
        assertThrows(IllegalArgumentException.class, () -> new MangaId("   "));
    }
}
