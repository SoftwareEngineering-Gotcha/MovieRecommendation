package edu.knu.se.domain;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name="FOR_USER_SEQ",
        sequenceName = "SEQ_USER",
        initialValue = 0,
        allocationSize = 1
)

@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FOR_USER_SEQ")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Long userid;

    private String passwd;

    public User() {}

    public User(Long uid, String passwd, ArrayList<Integer> genreScore, ArrayList<Integer> movieList){
        this.userid = uid;
        this.passwd = passwd;

    }


    public Long getUserid(){
        return this.userid;
    }

    public void setUserid(Long uid){
        this.userid = uid;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() { return this.passwd; }

/*
    @Override
    public String toString(){
        return "USER{" + "id= " + this.id + ", pw= " + this.passwd + "}";
    }*/
}