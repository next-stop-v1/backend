package project.NextStop.domain.subway.entity;

import jakarta.persistence.*;
import lombok.Builder;
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

    protected Subway() {
    }

    @Builder
    public Subway(int number,Boolean isRapid){
        this.number = number;
        this.isRapid = isRapid;
    }
}
