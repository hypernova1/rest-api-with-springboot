package org.melchor.restapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}