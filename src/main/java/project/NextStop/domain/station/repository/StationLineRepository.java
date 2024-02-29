package project.NextStop.domain.station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.station.entity.StationLine;

public interface StationLineRepository extends JpaRepository<StationLine,Long> {
}
