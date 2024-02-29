package project.NextStop.domain.line.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.line.entity.Line;

public interface LineRepository extends JpaRepository<Line,Long> {
}
