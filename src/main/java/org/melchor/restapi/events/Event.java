package org.melchor.restapi.events;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
@ToString
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventState eventState = EventState.DRAFT;

    public void update() {
        this.free = this.basePrice == 0 && this.maxPrice == 0;
        this.offline = !StringUtils.isEmpty(this.location);
    }
}
