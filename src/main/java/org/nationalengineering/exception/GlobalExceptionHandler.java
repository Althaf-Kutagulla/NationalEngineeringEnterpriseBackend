package org.nationalengineering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleCustomerException(CustomerNotFoundException customerNotFoundException, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        customerNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->
                errors.put(error.getField(),error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({WorkerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleWorkerException(WorkerNotFoundException workerNotFoundException, WebRequest webRequest){
        String message = webRequest.getContextPath();
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        workerNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }
}
