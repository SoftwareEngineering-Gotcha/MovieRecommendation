package edu.knu.se;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String uid){
        super("Could not find User " + uid);
    }
}
