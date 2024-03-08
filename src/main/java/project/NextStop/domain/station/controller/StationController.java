package project.NextStop.domain.station.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.NextStop.domain.schedule.repository.ScheduleRepository;
import project.NextStop.domain.station.dto.StationDto;
import project.NextStop.domain.station.service.StationService;
import project.NextStop.util.ResultDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @GetMapping("/station/detail")
    public ResultDto<List<StationDto>> getStationDtoApi(@RequestParam Long stationId) {

        List<StationDto> stationDtos = stationService.findStationDetail(stationId);
        return (!stationDtos.isEmpty()) ? new ResultDto<>(stationDtos,"정상 처리 되었습니다.",HttpStatus.OK)
                : new ResultDto<>("존재 하지 않는 역 입니다.",HttpStatus.NOT_FOUND);
    }
}
