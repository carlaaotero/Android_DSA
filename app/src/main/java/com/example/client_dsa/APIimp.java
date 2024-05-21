package com.example.client_dsa;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class APIimp {
    //BASE_URL conté la URL base de l'API del servidor
    public static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    private static API api;

    /*Constructor privat per evitar que es pugui instanciar externament,
     * només es podrà obtenir una instància de CLient amb getClient()*/
    private APIimp(){
    }
    public static API getAPI() {
        //Si encara no s'ha creat cap instància, es crea una nova instància
        if (api == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            api = retrofit.create(API.class);
        }
        return api;

    }

}
