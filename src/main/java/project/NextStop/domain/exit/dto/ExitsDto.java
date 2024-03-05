package project.NextStop.domain.exit.dto;

import lombok.Data;
import project.NextStop.domain.exit.entity.Exit;

@Data
public class ExitsDto {

    private int number;
    private String name;

    public ExitsDto(Exit exit) {
        this.number = exit.getNumber();
        this.name = exit.getName();
    }
}
