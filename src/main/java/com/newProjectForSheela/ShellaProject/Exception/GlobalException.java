package com.newProjectForSheela.ShellaProject.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    private Logger logger=LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler
    public ResponseEntity<?>  handlerPlayException(Com.Team.Creation.demo.Exception.EmployeeException exception){
        logger.error("Play Exception:{}",exception.getErrorMessage());
        return new ResponseEntity<>(Com.Team.Creation.demo.Exception.ErrorResponse.builder().message(exception.getErrorMessage()).build(),exception.getStatus());
    }
}
