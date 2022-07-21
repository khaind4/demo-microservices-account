package com.khaind.microservices.account.dto;

import java.sql.Timestamp;

public class UserDTO {

    private Long id;

    private String name;

    private String gender;

    private Timestamp birthday;

    private String address;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
