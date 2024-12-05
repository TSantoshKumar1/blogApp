package com.blogapp12.exception;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message){

        super(message);
    }
}
