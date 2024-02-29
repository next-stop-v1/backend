package project.NextStop.domain.line.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Line {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String tel;
}
