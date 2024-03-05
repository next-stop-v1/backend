package project.NextStop.domain.schedule.repository;

import project.NextStop.domain.schedule.entity.Schedule;

public interface ScheduleRepositoryCustom {

    Schedule getStationDetail(Long subwayId);
}
