package project.NextStop.domain.schedule.repository;

import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.station.entity.Station;

public interface ScheduleRepositoryCustom {

    Schedule findStationDetail(Long subwayId);
}
