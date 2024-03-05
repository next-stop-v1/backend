package project.NextStop.domain.station.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.NextStop.domain.schedule.entity.Schedule;
import project.NextStop.domain.schedule.repository.ScheduleRepository;
import project.NextStop.domain.station.dto.StationDetailDto;

@Service
@RequiredArgsConstructor
public class StationService {

    private final ScheduleRepository scheduleRepository;

    public StationDetailDto findStationDetail(Long subwayId){
        Schedule findSchedule = scheduleRepository.getStationDetail(subwayId);
        return new StationDetailDto(findSchedule.getStationLine().getNext());
    }

}
