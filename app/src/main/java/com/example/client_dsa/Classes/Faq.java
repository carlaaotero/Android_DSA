package com.example.client_dsa.Classes;

public class Faq {
    private String f;
    private String q;
    private String id;

    // Constructor vacío requerido por Gson para la deserialización
    public Faq(String f, String q) {
        this.f = f;
        this.q = q;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}
}

