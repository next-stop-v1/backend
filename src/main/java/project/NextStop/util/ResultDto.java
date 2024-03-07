package project.NextStop.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResultDto<T> {
    private T data;
    private String message;
    private HttpStatus statusCode;

    public ResultDto(T data, String message, HttpStatus statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public ResultDto(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
