package project.NextStop.domain.station.entity;

import jakarta.persistence.*;
import lombok.Getter;
import project.NextStop.util.valuetype.Address;

import java.math.BigDecimal;

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

    @Column(nullable = false, precision = 21, scale = 18)
    private BigDecimal latitude;

    @Column(nullable = false, precision = 21, scale = 18)
    private BigDecimal longitude;

    @Column(nullable = false)
    private Boolean isExpress;
}
