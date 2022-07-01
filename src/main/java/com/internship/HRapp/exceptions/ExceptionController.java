package com.internship.HRapp.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entitynotFoundException) {
        return new ResponseEntity<String>("Id not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<String>("Username not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>("Id not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException) {
        return new ResponseEntity<String>("Id not found!", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleAllException(EmptyResultDataAccessException emptyResultDataAccessException) {
        return new ResponseEntity<String>("Id not found!", HttpStatus.NOT_FOUND);
    }
}