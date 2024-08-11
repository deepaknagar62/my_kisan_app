package com.example.mykisanapp.Model;

public class User {
    private int userId;
    private String phone;
    private String name;
    private String village;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int userId, String phone, String name, String village) {
        this.userId = userId;
        this.phone = phone;
        this.name = name;
        this.village = village;

    }

    public User() {
    }
}
