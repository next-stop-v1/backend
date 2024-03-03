package project.NextStop.domain.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.NextStop.domain.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> , ScheduleRepositoryCustom{
}
