package ir.maktabsharif127.main.config;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {

    private final int status;

    public GeneralException(String message, int status) {
        super(message);
        this.status = status;
    }


}
