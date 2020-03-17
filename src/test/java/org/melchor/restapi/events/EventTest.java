package org.melchor.restapi.events;

import junitparams.JUnitParamsRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
class EventTest {

    @Test
    void builder() {
        Event event = Event.builder().build();

        assertThat(event).isNotNull();
    }

    @Test
    void javaBean() {
        Event event = new Event();
        String name = "Event";
        event.setName(name);
        event.setDescription("Spring");
        assertThat(event.getName()).isEqualTo(name);
    }

    private static Object[] paramsForTestFree() {
        return new Object[] {
                new Object[] { 0, 0, true },
                new Object[] { 100, 0, false },
                new Object[] { 0, 100, false },
                new Object[] { 100, 200, false }
        };
    }

    @ParameterizedTest
    @MethodSource("paramsForTestFree")
    void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    private static Object[] paramsForTestOffline() {
        return new Object[] {
                new Object[] { "강남", true },
                new Object[] { null, false },
                new Object[] { "", false }
        };
    }

    @ParameterizedTest
    @MethodSource("paramsForTestOffline")
    void testOffline(String location, boolean isOffline) {
        // Given
        Event event = Event.builder()
                .location(location)
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }

}