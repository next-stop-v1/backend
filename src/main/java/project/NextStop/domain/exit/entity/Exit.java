package project.NextStop.domain.exit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import project.NextStop.domain.station.entity.Station;

@Entity
@Getter
@Table(name = "exits")
public class Exit {

    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "exits_id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id",nullable = false)
    private Station station;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String name;
}
