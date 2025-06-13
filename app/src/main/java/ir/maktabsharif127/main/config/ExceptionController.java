package ir.maktabsharif127.main.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@ControllerAdvice
@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorInfo> handleRuntimeException(RuntimeException runtimeException) {
        return ResponseEntity.status(500)
                .body(
                        new ErrorInfo(runtimeException.getMessage())
                );
    }


    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity<ErrorInfo> handleGeneralException(GeneralException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(
                        new ErrorInfo(exception.getMessage())
                );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        List<ErrorDTO> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorInfo {
        private String message;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ErrorDTO implements Serializable {
        private String field;
        private String message;
    }
}
