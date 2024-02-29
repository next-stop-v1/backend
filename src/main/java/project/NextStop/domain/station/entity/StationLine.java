package project.NextStop.domain.station.entity;

import jakarta.persistence.*;
import lombok.Getter;
import project.NextStop.domain.line.entity.Line;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class StationLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_line_id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private Line line;

    @Column(nullable = false)
    private String doorDirection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_station_line_id")
    private StationLine previous;

    @OneToMany(mappedBy = "previous")
    private List<StationLine> previousStationLines = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_station_line_id")
    private StationLine next;

    @OneToMany(mappedBy = "next")
    private List<StationLine> nextStationLines= new ArrayList<>();
}
