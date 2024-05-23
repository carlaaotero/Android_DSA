package com.example.client_dsa;

import com.example.client_dsa.Classes.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//com.example.client_dsa
public class RegistreActivity extends AppCompatActivity {
    /*Declaració de variables */
    String id;
    private EditText nom;
    private EditText cognom;
    private EditText nomUsuari;
    private EditText contra;
    private EditText contra2;
    private Button registre;
    private ProgressBar progressBar;
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
        progressBar = findViewById(R.id.progressBar2);

        registre = findViewById(R.id.registre);

        api = APIimp.getAPI();


        registre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                //S'obté les dades introduïdes per l'usuari
                String nombre = nom.getText().toString();
                String apellido = cognom.getText().toString();
                String username = nomUsuari.getText().toString();
                String password = contra.getText().toString();
                String password2 = contra2.getText().toString();

                //validar que les constrasenyes coincideixen
                if(!password.equals(password2)){
                    Toast.makeText(RegistreActivity.this, "Les constrasenyes no coincideixen", Toast.LENGTH_LONG).show();
                }

                RegisterComp registreComp = new RegisterComp(nombre, apellido, username, password, password2);
                Call<RegisterComp> call = api.registre(registreComp);

                call.enqueue(new Callback<RegisterComp>() {
                    @Override
                    public void onResponse(Call<RegisterComp> call, Response<RegisterComp> response) {

                        if(!response.isSuccessful()){
                            Log.d("REGISTRE","USUARI NO REGISTRAT");
                            Toast.makeText(RegistreActivity.this,"Error al registrar", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Log.d("REGISTRE", "201 OK");

                        //RegisterComp usuari = response.body();
                        Toast.makeText(RegistreActivity.this,"User registrated", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegistreActivity.this, LoginActivity.class);
                        startActivity(intent);

                    }
                    @Override
                    public void onFailure(Call<RegisterComp> call, Throwable t) {
                        Log.d("REGISTRE", "ERROR:" + t.getMessage());
                        Toast.makeText(RegistreActivity.this,"ERROR:" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
