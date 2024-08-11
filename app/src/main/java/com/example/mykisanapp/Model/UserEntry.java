package com.example.mykisanapp.Model;

public class UserEntry {


    private int order_id;
    private String phone;
    private String fileUrl;
    private String type_sell;
    private String price;
    private String about_sell;
    private String village;
    private String date;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getType_sell() {
        return type_sell;
    }

    public void setType_sell(String type_sell) {
        this.type_sell = type_sell;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAbout_sell() {
        return about_sell;
    }

    public void setAbout_sell(String about_sell) {
        this.about_sell = about_sell;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserEntry(int order_id,int userId,  String phone, String fileUrl,
                     String type_sell, String price, String about_sell, String village, String date) {
        this.order_id = order_id;
        this.userId = userId;
        this.phone = phone;
        this.fileUrl = fileUrl;
        this.type_sell = type_sell;
        this.price = price;
        this.about_sell = about_sell;
        this.village = village;
        this.date = date;
    }

    public UserEntry() {
    }
}
