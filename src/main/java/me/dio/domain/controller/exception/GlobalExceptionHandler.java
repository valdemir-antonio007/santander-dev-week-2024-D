package me.dio.domain.controller.exception;

import me.dio.domain.model.Bootcamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalException(IllegalArgumentException ilegalException){
        return new ResponseEntity<>(ilegalException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNosuchException(NoSuchElementException noSuchException){
        return new ResponseEntity<>("Bootcamp not founds.", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleunexptedException(Throwable unexptedException){
       var message = "InternalServer error, see logs";
       logger.error(message, unexptedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
