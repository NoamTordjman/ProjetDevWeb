package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler({
            UserNonExistent.class,
            RegistrationNonExistent.class,
            EventNonExistant.class,
            FeedbackNonExistent.class
    })
    public ResponseEntity<String> handleNotFoundException(Exception ex){
        logger.warn("[NOT FOUND] {}",  ex.getMessage());
        return ResponseEntity.status(403).body(ex.getMessage());
    }

    @ExceptionHandler({
    })
    public ResponseEntity<String> handleNameException(Exception ex){
        logger.warn("[Existing Name] {}",  ex.getMessage());
        return ResponseEntity.status(402).body(ex.getMessage());
    }

    @ExceptionHandler(
            {UserAlreadyRegisteredException.class})
    public ResponseEntity<String> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException ex) {
        logger.warn("[User Already Registered] {}",  ex.getMessage());
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    }





