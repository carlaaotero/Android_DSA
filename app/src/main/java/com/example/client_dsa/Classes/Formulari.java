package com.example.client_dsa.Classes;

public class Formulari {
    String data;
    String title;
    String message;
    String sender;
    String id;

    public Formulari (){}
    public Formulari(String data, String title, String message, String sender){
        this.data = data;
        this.title = title;
        this.message = message;
        this.sender = sender;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data=data;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message=message;
    }
    public String getSender() {
        return this.sender;
    }
    public void setSender(String sender) {
        this.sender=sender;
    }
}
