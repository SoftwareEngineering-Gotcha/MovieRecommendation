package edu.knu.se.service;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String id){
        super("Could not find User " + id);
    }
}
