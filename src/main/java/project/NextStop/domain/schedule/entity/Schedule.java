package project.NextStop.domain.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import project.NextStop.domain.station.entity.StationLine;
import project.NextStop.domain.subway.entity.Subway;
import java.time.LocalTime;

@Entity
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_line_id", nullable = false)
    private StationLine stationLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subway_id", nullable = false)
    private Subway subway;

    @Column(nullable = false)
    private String dayStatus;

    @Column(nullable = false)
    private LocalTime arriveTime;

    @Column(nullable = false)
    private String direction;
}
