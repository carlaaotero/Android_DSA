package com.example.client_dsa.Classes;

public class LoginComp {
    private String nomusuari;
    private String password;
    public LoginComp (String nomusuari, String password){
        this.nomusuari=nomusuari;
        this.password=password;
    }
    public String getUsername() {
        return nomusuari;
    }
    public void setUsername(String nomusuari) {
        this.nomusuari = nomusuari;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        return nomusuari;
    }
}
