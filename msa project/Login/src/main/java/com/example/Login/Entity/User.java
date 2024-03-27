package com.example.Login.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name="userid", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    @Column(name="name", length = 255)
    private String name;
    @Column(name="password", length = 255)
    private String password;

    public User(int userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public User() {
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
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    @Transient
    private List<Order> info = new ArrayList<>();
}
