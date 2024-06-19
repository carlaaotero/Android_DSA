package com.example.client_dsa;

import com.example.client_dsa.Classes.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    //Un usuari es registra
    @POST("usuarisDAO/registreUsuarisDAO")
    Call<RegisterComp> registre(@Body RegisterComp register);

    //Un usuari inicia sessió
    @POST("usuarisDAO/loginDAO")
    Call<LoginComp> login(@Body LoginComp login);



    @GET("usuarisDAO/getPerfilDAO/{nomusuari}")
    Call<Usuari> getUsuariAPI(@Path("nomusuari") String nomusuari);

    @POST("usuarisDAO/comprarItemDAO/{nomusuari} {color}")
    Call<Usuari> comprar(@Query("nomusuari") String nomusuari, @Query("color") String item);

    //Retorna una llista amb els objectes de la botiga
    @GET("items/LlistaBotiga")
    Call<List<Item>> getBotiga();

    @POST("issues/addIssue")
    Call<Issue> addIssue(@Body Issue issue);

    @POST("usuaris/formulariSolicitud")
    Call<Formulari> formulari(@Body Formulari formulari);

    @GET("/usuaris/FAQs")
    Call<List<Faq>> getFaqs();

    //Per auntenticar l'usuari
    // @GET("/user")
    //Call<Usuari> getUserDetails(@Header("Authorization") String credentials);

    /*@GET("/usuaris/ranking")
    Call<List<Usuari>> getRanking();*/
}
