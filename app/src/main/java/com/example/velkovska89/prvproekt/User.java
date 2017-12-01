package com.example.velkovska89.prvproekt;

import java.io.Serializable;

/**
 * Created by Velkovska89 on 11/26/2017.
 */

public class User implements Serializable{

    public String Name;
    public String Lastname;
    public String Userename;
    public Boolean Gender;

    public User(String name, String lastname, String userename, Boolean gender) {
        Name = name;
        Lastname = lastname;
        Userename = userename;
        Gender = gender;
    }

    public User () {
        Name = "Guest";
        Lastname = "Guest";
        Userename = "Guest Username";
        Gender = true;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUserename() {
        return Userename;
    }

    public void setUserename(String userename) {
        Userename = userename;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return getUserename();
    }
}

