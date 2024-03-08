package project.NextStop.domain.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.schedule.repository.ScheduleRepository;
import project.NextStop.domain.station.dto.StationDto;
import project.NextStop.domain.station.entity.Station;
import project.NextStop.domain.station.entity.StationLine;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StationService {

    private final ScheduleRepository scheduleRepository;

    public StationDto findStation(Long subwayId){
        List<Schedule> scheduleList = scheduleRepository.getStation(subwayId);
        Schedule findSchedule = scheduleList.get(0);
        return new StationDto(findSchedule.getStationLine().getNext());
    }

    public List<StationDto> findStationDetail(Long stationId){
        List<StationDto> stationDtos = new ArrayList<>();
        List<StationLine> stationLines = scheduleRepository.getStationDetail(stationId);
        for (StationLine stationLine : stationLines) {
            StationDto stationDto = new StationDto(stationLine);
            stationDtos.add(stationDto);
        }
        return stationDtos;
    }

}
