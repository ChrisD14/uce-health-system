package ec.edu.uce.auth.exception;

import ec.edu.uce.auth.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> handleRuntime(
            RuntimeException ex) {

        return ResponseEntity.badRequest()
                .body(new ApiResponse(ex.getMessage()));
    }
}