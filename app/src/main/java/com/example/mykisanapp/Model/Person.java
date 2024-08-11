package com.example.mykisanapp.Model;

public class Person {

    private int id;
    private String name;
    private String village;
    private String fileUrl;

    public Person() {
    }

    public Person(int id, String name, String village, String fileUrl) {
        this.id = id;
        this.name = name;
        this.village = village;
        this.fileUrl = fileUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
