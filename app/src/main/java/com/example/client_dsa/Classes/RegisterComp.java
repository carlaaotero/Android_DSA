package com.example.client_dsa.Classes;

public class RegisterComp {
    String nom;
    String cognom;
    String nomusuari;
    String password;
    String password2;

    public RegisterComp (String nom, String cognom, String nomusuari, String password, String password2){
        this.nom=nom;
        this.cognom = cognom;
        this.nomusuari = nomusuari;
        this.password=password;
        this.password2 = password2;
    }

    public void setNom(String nom) {this.nom = nom;}
    public String getNom() {return nom;}
    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}
    public void setCognom(String cognom) {this.cognom = cognom;}
    public String getCognom() {return cognom;}
    public void setNomusuari(String nomusuari) {this.nomusuari = nomusuari;}
    public String getNomUsuari() {return nomusuari;}
    public void setPassword2(String password2) {this.password2 = password2;}
    public String getPassword2() {return password2;}
}