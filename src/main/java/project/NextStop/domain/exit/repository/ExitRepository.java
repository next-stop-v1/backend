package project.NextStop.domain.exit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.exit.entity.Exit;

public interface ExitRepository extends JpaRepository<Exit,Long> {
}
