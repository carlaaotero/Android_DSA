package com.example.client_dsa.Classes;

public class Faq {
    private String f;
    private String q;

    // Constructor vacío requerido por Gson para la deserialización
    public Faq() {
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
}

