package com.example.Login.DTO;

public class LoginDTO {
    private String password;
    private String name;

    public LoginDTO(String password, String name) {
        this.password = password;
        this.name =  name;
    }

    public LoginDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
