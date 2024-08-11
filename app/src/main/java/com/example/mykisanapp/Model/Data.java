package com.example.mykisanapp.Model;

public class Data {
    int userId;
    String name,village, phone;

    public Data(int userId, String name, String village, String phone) {
        this.userId = userId;
        this.name = name;
        this.village = village;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
