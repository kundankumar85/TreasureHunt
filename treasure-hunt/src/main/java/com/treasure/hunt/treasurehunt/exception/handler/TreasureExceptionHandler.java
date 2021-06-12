package com.treasure.hunt.treasurehunt.exception.handler;

import com.treasure.hunt.treasurehunt.exception.InvalidTreasureMatrixException;
import com.treasure.hunt.treasurehunt.exception.TreasureNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Global Exception Handler.
 */
@ControllerAdvice
@Slf4j
public class TreasureExceptionHandler {
    private static final String MESSAGE = "message";
    private static final String EXCEPTION_MSG = "Exception found.";

    @ExceptionHandler(value = {TreasureNotFoundException.class})
    public ResponseEntity<Object> handleTreasureNotFoundException( HttpServletRequest req, TreasureNotFoundException ex){
        Map<String,Object> error = new HashMap<>();
        error.put(MESSAGE,ex.getMessage());
        log.error(EXCEPTION_MSG, ex);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = {InvalidTreasureMatrixException.class})
    public ResponseEntity<Object> handleInvalidTreasureMatrixException( HttpServletRequest req, InvalidTreasureMatrixException ex){
        Map<String,Object> error = new HashMap<>();
        error.put(MESSAGE,ex.getMessage());
        log.error(EXCEPTION_MSG, ex);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException( HttpServletRequest req, Exception ex){
        Map<String,Object> error = new HashMap<>();
        error.put(MESSAGE,ex.getMessage());
        log.error(EXCEPTION_MSG, ex);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(HttpServletRequest req,MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String,String> errors =fieldErrors.stream().collect(Collectors.toMap(FieldError::getField, error->error.getDefaultMessage()));
        log.error(EXCEPTION_MSG, ex);
        return ResponseEntity.badRequest().body(errors);
    }

}
