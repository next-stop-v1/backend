package project.NextStop.domain.subway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.subway.entity.Subway;

public interface SubwayRepository extends JpaRepository<Subway,Long> {
}
