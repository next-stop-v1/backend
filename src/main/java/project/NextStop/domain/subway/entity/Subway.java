package project.NextStop.domain.subway.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Subway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subway_id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private Boolean isRapid;
}
