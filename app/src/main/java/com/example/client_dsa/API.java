package com.example.client_dsa;

import com.example.client_dsa.Classes.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
public interface API {
    //Un usuari es registra
    @POST("/registre")
    Call<RegisterComp> registre(@Body RegisterComp register);
    //Un usuari inicia sessió
    @POST("/login")
    Call<LoginComp> login(@Body LoginComp login);
    //Per auntenticar l'usuari
    @GET("/user")
    Call<Usuari> getUserDetails(@Header("Authorization") String credentials);
    //Retorna una llista amb els objectes de la botiga

    /* @GET("/shop")
    Call<Void> botiga(@Body Botiga camiseta);*/

}
