package project.NextStop.domain.schedule.repository;

import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.station.entity.Station;
import project.NextStop.domain.station.entity.StationLine;

import java.util.List;

public interface ScheduleRepositoryCustom {

    List<Schedule> getStation(Long subwayId);

    List<StationLine> getStationDetail(Long stationId);
}
