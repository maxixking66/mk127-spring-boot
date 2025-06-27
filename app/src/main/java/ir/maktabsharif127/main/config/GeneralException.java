package ir.maktabsharif127.main.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends RuntimeException {

    private final int status;

    private final HttpStatus httpStatus;

    public GeneralException(String message, int status) {
        super(message);
        this.status = status;
        this.httpStatus = HttpStatus.resolve(status);
    }

    public GeneralException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.status = this.httpStatus.value();
    }


}
