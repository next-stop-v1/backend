package project.NextStop.domain.station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.station.entity.Station;

public interface StationRepository extends JpaRepository<Station,Long> {
}
