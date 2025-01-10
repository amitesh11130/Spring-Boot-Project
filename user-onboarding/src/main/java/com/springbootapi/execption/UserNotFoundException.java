package com.springbootapi.execption;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String msg){
        super(msg);
    }

}
