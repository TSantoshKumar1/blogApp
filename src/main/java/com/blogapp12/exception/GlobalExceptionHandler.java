package com.blogapp12.exception;

import com.blogapp12.payload.ErrorDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



// for handling perticular specific exception or custom exception

    @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ErrorDetailsDto> HandlerResourceNotFoundException(ResourceNotFoundException e , WebRequest webRequest){

        ErrorDetailsDto error = new ErrorDetailsDto(new Date(),e.getMessage(),webRequest.getDescription(false));


        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
   }






   @ExceptionHandler(Exception.class)
 public ResponseEntity<String> globalExceptionHandler(Exception e ){

        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
 }

}
