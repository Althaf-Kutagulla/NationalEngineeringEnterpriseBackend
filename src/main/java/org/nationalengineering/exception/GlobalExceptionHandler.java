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

    @ExceptionHandler({MotorNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleMotorException(MotorNotFoundException motorNotFoundException, WebRequest webRequest){
        String message = webRequest.getContextPath();
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        motorNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CategoryNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleCategoryException(CategoryNotFoundException categoryNotFoundException, WebRequest webRequest){
        String message = webRequest.getContextPath();
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        categoryNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleProductNotException(ProductNotFoundException productNotFoundException, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        productNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MotorTicketNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleMotorTicketException(MotorTicketNotFoundException motorTicketNotFoundException, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        motorTicketNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ProductException.class})
    public ResponseEntity<ErrorResponse> handleProductException(ProductException productException, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.BAD_REQUEST.toString(),
                        productException.getMessage()
                ),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ProductUsageNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleProductNotException(ProductUsageNotFoundException productUsageNotFoundException, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorResponse(
                        webRequest.getDescription(false).replace("uri=",""),
                        HttpStatus.NOT_FOUND.toString(),
                        productUsageNotFoundException.getMessage()
                ),HttpStatus.NOT_FOUND);
    }
}
