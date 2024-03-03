package project.NextStop.domain.station.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;
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
    @BatchSize(size = 500)
    private List<StationLine> previousStationLines = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_station_line_id")
    private StationLine next;

    @OneToMany(mappedBy = "next")
    @BatchSize(size = 500)
    private List<StationLine> nextStationLines= new ArrayList<>();

    protected StationLine() {
    }

    @Builder
    public StationLine(Station station, String doorDirection){
        this.station = station;
        this.doorDirection = doorDirection;
    }

    //=== 연관관계 메서드 ===//
    public void addPrevious(StationLine previous){
        this.previous = previous;
        previousStationLines.add(previous);
    }

    public void addNext(StationLine next){
        this.next = next;
        nextStationLines.add(next);
    }
}
