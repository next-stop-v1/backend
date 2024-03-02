package project.NextStop.domain.station.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;
import project.NextStop.domain.exit.entity.Exit;
import project.NextStop.util.valuetype.Address;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Station {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    @Column(nullable = false)
    private Address address;

    @Column(nullable = false)
    private Boolean isExpress;

    @OneToMany(mappedBy = "station")
    @BatchSize(size = 500)
    private List<Exit> exits = new ArrayList<>();

    protected Station() {
    }

    @Builder
    public Station(String name, Address address, Boolean isExpress){
        this.name = name;
        this.address = address;
        this.isExpress = isExpress;
    }


}
