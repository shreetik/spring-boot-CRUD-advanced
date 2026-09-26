package com.shreetik.CRUD.globalException;

public class UserNotFoundException extends RuntimeException {
   public UserNotFoundException(String message){
        super(message);
    }
}
