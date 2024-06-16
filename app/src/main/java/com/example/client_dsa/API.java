package com.example.client_dsa;

import com.example.client_dsa.Classes.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    //Un usuari es registra
    @POST("usuaris/registreUsuari")
    Call<RegisterComp> registre(@Body RegisterComp register);

    //Un usuari inicia sessió
    @POST("usuaris/login")
    Call<LoginComp> login(@Body LoginComp login);

    //Retorna una llista amb els objectes de la botiga
    @GET("items/llistaUsuaris")
    Call<Item> getItems(@Body Item llistaItem);

    @GET("usuaris/getPerfil/{nomusuari}")
    Call<Usuari> getUsuariAPI(@Path("nomusuari") String nomusuari);


    @POST("issues/addIssue")
    Call<Issue> addIssue(@Body Issue issue);

    @POST("usuaris/formulariSolicitud")
    Call<Formulari> formulari(@Body Formulari formulari);

    @GET("/usuaris/FAQs")
    Call<List<Faq>> getFaqs();

    //FALTA @POST per quan compres un item

    //Per auntenticar l'usuari
    // @GET("/user")
    //Call<Usuari> getUserDetails(@Header("Authorization") String credentials);

    @GET("/usuaris/ranking")
    Call<List<Usuari>> getRanking();
}
