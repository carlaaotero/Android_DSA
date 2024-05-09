package com.example.client_dsa;

import com.example.client_dsa.Classes.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistreActivity extends AppCompatActivity {
    /*Declaració de variables */
    String id;
    private EditText nom;
    private EditText cognom;
    private EditText nomUsuari;
    private EditText contra;
    private EditText contra2;
    private Button registre;
    API api;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        /*Generem un numero random per l'ID*/
        Random rand = new Random();
        id = String.valueOf(rand.nextInt(1000));

        /*Assignació de les referències als elements de la interfície*/
        nom = findViewById(R.id.nom);
        cognom = findViewById(R.id.cognom);
        nomUsuari = findViewById(R.id.nomUsuarii);
        contra = findViewById(R.id.contra1);
        contra2 = findViewById(R.id.contra2);

        registre = findViewById(R.id.registre);


        registre.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //S'obté les dades introduïdes per l'usuari
                String nombre = nom.getText().toString();
                String apellido = cognom.getText().toString();
                String username = nomUsuari.getText().toString();
                String password = contra.getText().toString();
                String password2 = contra2.getText().toString();

                //FER FUNCIÓ DE SI S'HA REALITZAT BÉ EL REGISTRE FA EL SEGÜENT:
                Intent intent = new Intent(RegistreActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        String nombre = nom.getText().toString();
        String apellido = cognom.getText().toString();
        String username = nomUsuari.getText().toString();
        String password = contra.getText().toString();
        String password2 = contra2.getText().toString();
        RegisterComp registerComp = new RegisterComp(nombre, apellido, username, password, password2);
        Callback<RegisterComp> tCallback = new Callback<RegisterComp>() {
            @Override
            public void onResponse(Call<RegisterComp> call, Response<RegisterComp> response) {
                Log.d("PROVA", "TINC RESPOSTA");
            }

            @Override
            public void onFailure(Call<RegisterComp> call, Throwable t) {
                Log.d("PROVA", "TINC UN ERROR");
            }
        };
        api.registre(registerComp).enqueue(tCallback);

    }
    public void anarLogin(View view)
    {
        Intent intent = new Intent(RegistreActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
