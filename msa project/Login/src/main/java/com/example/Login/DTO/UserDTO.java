package com.example.Login.DTO;

import jakarta.persistence.Column;

public class UserDTO {
    private int userid;
    private String name;
    private String password;

    public UserDTO(int userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public UserDTO() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
