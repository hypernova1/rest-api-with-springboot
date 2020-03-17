package org.melchor.restapi.events;

import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

// Serialize 할때 BeanSerialize 를 사용 : 필드 이름으로 만듬
@Getter
public class EventResource extends EntityModel<Event> {

    public EventResource(Event content, Link... links) {
        super(content, links);
        add(linkTo(EventController.class).slash(content.getId()).withSelfRel());
    }
}
