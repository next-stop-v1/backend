package project.NextStop.domain.station.dto;

import lombok.Data;
import project.NextStop.domain.exit.dto.ExitsDto;
import project.NextStop.domain.station.entity.StationLine;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StationDto {

    private String stationName;
    private String doorDirection;
    private List<ExitsDto> exits;

    public StationDto(StationLine stationLine) {
        this.stationName = stationLine.getStation().getName();
        this.doorDirection = stationLine.getDoorDirection();
        this.exits = stationLine.getStation().getExits()
                .stream().map(exit -> new ExitsDto(exit)).collect(Collectors.toList());
    }

}
