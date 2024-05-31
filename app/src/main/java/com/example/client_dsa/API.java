package com.example.client_dsa;

import com.example.client_dsa.Classes.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
public interface API {
    //Un usuari es registra
    @POST("usuaris/registreUsuari")
    Call<RegisterComp> registre(@Body RegisterComp register);

    //Un usuari inicia sessió
    @POST("usuaris/login")
    Call<LoginComp> login(@Body LoginComp login);

    //Retorna una llista amb els objectes de la botiga
    @GET("items/llista")
    Call<Item> getItems(@Body Item llistaItem);

    //FALTA @POST per quan compres un item

    //Per auntenticar l'usuari
    // @GET("/user")
    //Call<Usuari> getUserDetails(@Header("Authorization") String credentials);

    @GET("stats/ranking")
    Call<Usuari> ranking(@Body Usuari ranking);
}
