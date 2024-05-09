package com.example.client_dsa.Classes;

public class RegisterComp {
    String nom;
    String cognom;
    String nomUsuari;
    String contra;
    String contra2;

    public RegisterComp (String nom, String cognom, String nomUsuari, String contra, String contra2){
        this.nom=nom;
        this.cognom = cognom;
        this.nomUsuari = nomUsuari;
        this.contra=contra;
        this.contra2 = contra2;
    }

    public void setNom(String nom) {this.nom = nom;}
    public String getNom() {return nom;}
    public void setContra(String contra) {this.contra = contra;}
    public String getContra() {return contra;}
    public void setCognom(String cognom) {this.cognom = cognom;}
    public String getCognom() {return cognom;}
    public void setNomUsuari(String nomUsuari) {this.nomUsuari = nomUsuari;}
    public String getNomUsuari() {return nomUsuari;}
    public void setContra2(String contra2) {this.contra2 = contra2;}
    public String getContra2() {return contra2;}
}
